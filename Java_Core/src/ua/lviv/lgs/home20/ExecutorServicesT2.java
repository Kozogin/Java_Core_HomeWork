package ua.lviv.lgs.home20;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServicesT2 {

static int number;
	
	public int getNumber() {
		return number;		
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		
		System.out.println("Enter number members Fibonacci");
		Scanner sc = new Scanner(System.in);
		number = sc.nextInt();
		
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
				} catch (InterruptedException | ExecutionException e) {
					e.printStackTrace();
				}				
			}
		});
        System.out.println();
        
        obverse.shutdown();
        
        
        Timer time = new Timer();
        ReversTask revers = new ReversTask();
        time.schedule(revers, 0, 1000); // 

        for (int i = 0; i <= number; i++) {
            Thread.sleep(10);  
            System.out.println("Execution in Main Thread. #" + i);
            if (i == 5) {
                System.out.println("Application Terminates");
                //System.exit(0);
            }
        }
        
        
        
        
        
		
	}
}


class ReversTask extends TimerTask {

	@Override
	public void run() {
		System.out.println("dfgdhdhddjjdjjdjj");
	}
}
