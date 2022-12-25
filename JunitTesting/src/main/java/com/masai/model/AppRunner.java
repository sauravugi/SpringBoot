package com.masai.model;

public class AppRunner {
	
	public static void main(String[] args) {
		
		Calculator c = new Calculator();
		
		System.out.println("Addition of Numbers "+c.calculateAdd(5, 6));
		
		System.out.println("Multiply of Numbers "+c.calculateMulti(8, 9));
	}

}
