package com.uma.java8.custom;

public class TempHashSetInAppropriate {

	private final int MAX_SIZE= 1000;
	boolean[] vData= new boolean[MAX_SIZE + 1];
	
	public boolean add(int pVal) {
		try {
			vData[pVal]= true;
			return true;
		}
		catch(Exception e) {}
		return false;
	}
	
	public boolean remove(int pVal) {
		try {
			vData[pVal]= false;
			return true;
		}
		catch(Exception e) {}
		return false;
	}
	
	public boolean contains(int pVal) {
		return vData[pVal];
	}
	
}
