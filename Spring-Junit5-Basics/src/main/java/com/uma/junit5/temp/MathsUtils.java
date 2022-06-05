package com.uma.junit5.temp;

public class MathsUtils {

	public int add(int a, int b) {
		return a + b;
	}
	
	public int substract(int a, int b) {
		return a - b;
	}
	
	public int multiple(int a, int b) {
		return a * b;
	}
	
	public int divide(int a, int b) {
		return a / b;
	}
	
	public double computeCircleArea(double pRadius) {
		double vArea= 0.0;
		vArea= (22/7) * pRadius;
		return vArea;
	}
}
