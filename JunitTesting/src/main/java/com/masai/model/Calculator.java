package com.masai.model;

public class Calculator {
	
	public int calculateAdd(int a, int b) {
		return a+b;
	}
	
	public int calculateMulti(Object v1,Object v2) {
		int c=0;
		int v=0;
		if(v1 instanceof Integer && v1 instanceof Integer) {
			c=(int) v1;
			v=(int) v2;
		}else throw new ClassCastException("Enter Valid Value");
		
		return c*v;
	}

	public int divide() {
		return 12/0;
	}

}
