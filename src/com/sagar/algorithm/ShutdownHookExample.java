package com.sagar.algorithm;

public class ShutdownHookExample {

	public static void main(String[] args) {
		Thread hook = new Thread(() -> System.out.println("Hello"));
		Runtime.getRuntime().addShutdownHook(hook);
		
		Thread thread = new Thread(new Pauser());
		thread.start();
	}
}
