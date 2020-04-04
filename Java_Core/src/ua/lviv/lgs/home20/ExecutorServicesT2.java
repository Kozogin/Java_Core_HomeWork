package ua.lviv.lgs.home20;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorServicesT2 {

	static int number;
	
	public int getNumber() {
		return number;
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		
		System.out.println("Enter number members Fibonacci");
		Scanner sc = new Scanner(System.in);
		number = sc.nextInt();
		
		int timer = number + 2;
		
		Callable<List<Integer>> createFibo = () -> {
			List<Integer> fibo = new ArrayList<>();
			for (int i = 0; i < number; i++) {
				if(i == 0 || i == 1) {
					fibo.add(1);					
				} else {					
					fibo.add(fibo.get(i-2) + fibo.get(i-1));
				}
			}					
            return fibo;
        }; 
                
        ExecutorService executor = Executors.newFixedThreadPool(1);        
        Callable<List<Integer>> tasksList = createFibo;         
        Future<List<Integer>> results = executor.submit(tasksList); 
        
        while(!results.isDone())
        {
         Thread.sleep(1);
        }        
        executor.shutdown();
                
        //-----------------------------------------------------------------
        
        ExecutorService obverse = Executors.newSingleThreadExecutor();        
        obverse.execute(new Runnable() {
			
			@Override
			public void run() {
				try {
					Iterator<Integer> iterator = results.get().listIterator();
					while(iterator.hasNext()) {
						Thread.sleep(1000);
						System.out.print(iterator.next() + ", ");
					}	
					System.out.println(); 
					
				} catch (InterruptedException | ExecutionException e) {
					e.printStackTrace();
				}				
			}
		});              
        
        obverse.shutdown();
        
        //---------------------------------------------
        
        
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(4);
      Iterator<Integer> iterator1 = results.get().listIterator();
      while(iterator1.hasNext()) {
    	  iterator1.next();
      }
      
        Runnable revers = () -> {
						
			if(((ListIterator<Integer>) iterator1).hasPrevious()) {				
				System.out.print(((ListIterator<Integer>) iterator1).previous() + ", ");
			
			} else {
				System.out.println();
				System.out.println("exit");
				scheduledExecutorService.shutdown();
				System.exit(0);
			}
		};
		scheduledExecutorService.scheduleAtFixedRate(revers, timer, 1, TimeUnit.SECONDS);
        
	}
}

