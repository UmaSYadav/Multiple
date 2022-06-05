package com.uma.junit5.temp;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;


class MathsUtilsTest {

	MathsUtils vMathsUtils= null;
	TestInfo vTestInfo= null;
	TestReporter vTestReporter= null;
	
	
	@BeforeAll
	public static void beoreAll() {
		System.out.println("Before all...");
	}
	
	@BeforeEach
	public void init(TestInfo pTestInfo, TestReporter pTestReporter) {
		vMathsUtils= new MathsUtils();
		vTestInfo= pTestInfo;
		vTestReporter= pTestReporter;
	}
	
	@AfterEach
	public void cleanup() {
		System.out.println("Clean up...");
	}
	
	@Test
	@DisplayName("Test Multiply")
	void testmultiple() {
		int vExpected= 4;
		int vActual= vMathsUtils.multiple(2, 2);
		//assertEquals(vExpected, vActual, "Should add 2 numbers.");		
		assertAll(
			()-> assertEquals(4, vMathsUtils.multiple(2, 2), "Should multiply 2 numbers 2 & 2."),
			()-> assertEquals(6, vMathsUtils.multiple(3, 2), "Should multiply 2 numbers 3 & 2."),
			()-> assertEquals(-2, vMathsUtils.multiple(-1, 2), "Should multiply 2 numbers -1 & 2.")
		);
	}
	
	@Nested
	@DisplayName("Adding 2 numbers")
	class AddTest {

		@Test
		void testAdd() {
			boolean vStatus= false;
			assumeTrue(vStatus);
			assertEquals(3, vMathsUtils.add(1, 2), "Should add 2 numbers.");
		}

		@Test
		void testAddPositive() {
			assertEquals(3, vMathsUtils.add(1, 2), "Should add 2 numbers.");
		}

		@Test
		void testAddNegative() {
			assertEquals(-3, vMathsUtils.add(-1, -2), "Should add 2 numbers.");
		}
		
		@Test
		void testAddNegative2() {
			int vExpected= -3;
			int vActual= vMathsUtils.add(-1, -2);
			assertEquals(vExpected, vActual, ()-> "Should return : "+vExpected+", but returned: "+vActual);
			//Lambda executes only in case of failure
		}
	}
	
	
	
	@Test
	@EnabledOnOs(OS.LINUX)
	void testComputeCircleAreaLunux() {
		assertEquals((22/7 * 10), vMathsUtils.computeCircleArea(10), "Should return circle area.");
	}
	
	@Test
	@RepeatedTest(value = 3, name = "circle radius")
	void testComputeCircleArea() {
		assertEquals((22/7 * 10), vMathsUtils.computeCircleArea(10), "Should return circle area.");
	}
	
	/*
	@Test
	@RepeatedTest(value = 3, name = "circle radius tests")
	void testComputeCircleAreatr(RepetitionInfo pInfo) {
		assertEquals((22/7 * 10), vMathsUtils.computeCircleArea(10), "Should return circle area.");
	}
	*/
	
	@Test
	@Tag("Circle")
	void testComputeCircleAreaTag() {
		//System.out.println(pInfo.getCurrentRepetition());
		String vVal= "Running " + vTestInfo.getDisplayName()+", with tags- " + vTestInfo.getTags();
		System.out.println(vVal);
		vTestReporter.publishEntry(vVal);
		assertEquals((22/7 * 10), vMathsUtils.computeCircleArea(10), "Should return circle area.");
	}
	
	@Test
	@DisplayName("divide vy 0")
	@Disabled
	void testDivide() {
		assertThrows(ArithmeticException.class, ()-> vMathsUtils.divide(10, 0), "Divide by 0 should throw ArithmeticException.");
	}

}
