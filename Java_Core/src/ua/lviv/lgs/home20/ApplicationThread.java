package ua.lviv.lgs.home20;

import java.util.Scanner;

public class ApplicationThread {
	
	static int number;
	
	public int getNumber() {
		return number;		
	}

	public static void main(String[] args) throws InterruptedException {
		
		
		System.out.println("Enter number members Fibonacci");
		Scanner sc = new Scanner(System.in);
		number = sc.nextInt();
		
		MyThread thread1 = new MyThread();
		thread1.start();
		thread1.join();
		
		RunnableThread thread2 = new RunnableThread();

	}
}

class MyThread extends Thread{
	ApplicationThread at = new ApplicationThread();
	private int number = at.getNumber();
	
	@Override
	public void run() {
		
		int [] array = new int[number];
		for (int i = 0; i < array.length; i++) {
			if(i == 0 || i == 1) {
				array[i] = 1;
			} else {
				array[i] = array[i-2] + array[i-1];
			}
		}		
		
		for (int i : array) {
			System.out.print(i + ", ");
			try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		}
		System.out.println();		
	}
}

class RunnableThread implements Runnable{
	
	Thread tread2;
	ApplicationThread at = new ApplicationThread();
	
	private int number = at.getNumber();
	
	public RunnableThread() {
		this.tread2 = new Thread(this);
		tread2.start();
	}

	@Override
	public void run() {
		
		int [] array = new int[number];
		for (int i = 0; i < array.length; i++) {
			if(i == 0 || i == 1) {
				array[i] = 1;
			} else {
				array[i] = array[i-2] + array[i-1];
			}
		}		
		
		for (int j = array.length - 1; j > -1; j--) {
			System.out.print(array[j] + ", ");
			try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		}
		System.out.println();		
	}	
	
}
