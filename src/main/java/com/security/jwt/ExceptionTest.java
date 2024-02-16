package com.security.jwt;

public class ExceptionTest {
	
	
	
	public static void main(String args[]) {
		
		int a = 100;
		int b = 0;
		
		
		
		int result = 0;
		
		try {
			result = calculate(a, b);
		} catch(ArithmeticException ae) {
			System.out.println("oops... an error occured: " + ae);
		}
		
		System.out.println("result = " + result);
		
		
	}
	
	private static int calculate(int a, int b) {
		
		int result = 0;
		
		result = a / b;
		
		return result;
	}

}
