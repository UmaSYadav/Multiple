package com.uma.java8.custom;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TempHashSetAppropriate {

	private final int MAX_SIZE= 1000;
	private final int ARR_SIZE= 10;
	List<List<Integer>> parentList;
	
	public TempHashSetAppropriate() {
		parentList= new ArrayList<>(ARR_SIZE);
		for (int i= 0; i < ARR_SIZE; i++) {
			parentList.add(null);
		}
	}
	
	public void add(int pVal) {
		int index= pVal % ARR_SIZE;
		List<Integer> childList= parentList.get(index);
		if(childList == null) {
			List<Integer> list= new LinkedList<>();
			list.add(pVal);
			parentList.set(index, list);
		}
		else {
			if(!childList.contains(pVal)) {
				childList.add(pVal);
			}
		}
	}
	
	public void remove(int pVal) {
		int index= pVal % ARR_SIZE;
		List<Integer> childList= parentList.get(index);
		if(childList != null) {
			childList.remove(Integer.valueOf(pVal));
		}
	}
	
	public boolean contains(int pVal) {
		int index= pVal % ARR_SIZE;
		List<Integer> childList= parentList.get(index);
		return childList != null && childList.contains(pVal);
	}
	
}
