package com.sagar.algorithm;

public class Pauser implements Runnable {

	@Override
	public void run() {
		System.out.println("In thread Executionm");
		System.out.println(Thread.currentThread().getName());
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
