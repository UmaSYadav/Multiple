package com.uma.java8.intrv;

import com.uma.java8.custom.TempHashSetAppropriate;
import com.uma.java8.custom.TempHashSetInAppropriate;

public class VerifyHashmap {

	public static void main(String[] args) {
		methodTempHashSetInAppropriate();
		methodTempHashSetAppropriate();
	}

	private static void methodTempHashSetAppropriate() {
		TempHashSetAppropriate vTempHashSetAppropriate= new TempHashSetAppropriate();
		System.out.println("much better approach");
		vTempHashSetAppropriate.add(1);
		vTempHashSetAppropriate.add(10);
		vTempHashSetAppropriate.add(11);
		vTempHashSetAppropriate.add(21);
		
		System.out.println("5. "+vTempHashSetAppropriate.contains(1));
		System.out.println("6. "+vTempHashSetAppropriate.contains(9));
		System.out.println("7. "+vTempHashSetAppropriate.contains(10));
		
		vTempHashSetAppropriate.remove(10);
		System.out.println("9. "+vTempHashSetAppropriate.contains(10));
		
	}

	private static void methodTempHashSetInAppropriate() {
		TempHashSetInAppropriate vTempHashSetInAppropriate= new TempHashSetInAppropriate();
		
		System.out.println("1. "+vTempHashSetInAppropriate.add(1));
		System.out.println("2. "+vTempHashSetInAppropriate.add(10));
		System.out.println("3. "+vTempHashSetInAppropriate.add(11));
		System.out.println("4. "+vTempHashSetInAppropriate.add(21));
		
		System.out.println("5. "+vTempHashSetInAppropriate.contains(1));
		System.out.println("6. "+vTempHashSetInAppropriate.contains(9));
		System.out.println("7. "+vTempHashSetInAppropriate.contains(10));
		
		System.out.println("8. "+vTempHashSetInAppropriate.remove(10));
		System.out.println("9. "+vTempHashSetInAppropriate.contains(10));
		
	}

}
