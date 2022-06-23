package com.uma.java8.intrv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.uma.java8.intrv.interfaces.Multiply2Nos;

public class AddIntArrayList {

	public static void main(String[] args) {
		int x= 6;
		String vStatement= "CodeBeautify Logo JSON Formatter XML Formatter SEO Inspector Calculators JSON Beautifier Recent Links Sitemap Favs JSON Viewer";
		ArrayList<Integer> vIntArr= new ArrayList<>();
		vIntArr.add(1);vIntArr.add(18);vIntArr.add(1);vIntArr.add(15);vIntArr.add(5);vIntArr.add(15);
		
		//minMaxIntArray(vIntArr);
		//addIntArray(vIntArr);
		//twiceEvenIntArray(vIntArr);
		//findDuplicateElements(vIntArr);
		//add2NosByFunctionalInterface(10, 20);
		//diffBetweenLimitSkip(vIntArr);
		//countOcuuranceOfWords(vStatement);
		//checkPrimeNumber(x);
		//sqroot10Prime();
		//first15ArmstrongNum();
		//checkPrimeNumber2(x);
		//sqroot10Prime2();
		//first15ArmstrongNum2();
		//factorialNum(x);
		//factorialNum2(x);
		//fibSeries(x);
		//fibSeries2(x);
		
	}
	
	
	private static void fibSeries2(int x) {
		Stream.iterate(new int[] {0,1}, t-> new int[] {t[1], t[0]+t[1]}).map(t->t[0]).limit(x*2).forEach(System.out::println);
	}

	private static void fibSeries(int count) {
		Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
			.map(t -> t[0])
			.limit(count * 2).forEach(x->System.out.print(x +" "));
		System.out.println();
	}

	private static void factorialNum2(int x) {
		int vFact= IntStream.range(2, x).reduce(1, (a,b)-> a*b);
		System.out.println(vFact);
	}

	private static void factorialNum(int x) {
		int vFact= IntStream.range(2, x).reduce(1, (a, b) -> a * b);
		System.out.println(vFact);
	}

	private static void first15ArmstrongNum2() {
		List<Integer> vArm= Stream.iterate(1, i-> i+1)
				.filter((n) -> {
					int c= 0, temp= n;
					while(temp > 0) {
						c += Math.pow(temp%10, Integer.toString(n).length());
						temp /= 10;
					}
					return c==n;
				})
				.limit(15)
				.collect(Collectors.toList());
		System.out.println("sn::"+vArm);
	}

	private static void sqroot10Prime2() {
		List<Double> vFirst10= Stream.iterate(1, i->i+1)
				.filter(AddIntArrayList::checkPrimeNumber2)
				.map(Math::sqrt)
				.limit(10).collect(Collectors.toList());
		System.out.println(vFirst10);
	}

	private static boolean checkPrimeNumber2(int x) {
		boolean vpm= x == 1 ||IntStream.range(2, x).noneMatch(a-> x%a==0);
		return vpm;
	}

	private static void first15ArmstrongNum() {
		List<Integer> vArmNum= Stream.iterate(1, i-> i+1)
				.filter((n)-> {
					int c = 0, temp = n;
					while (temp > 0) {
						c += Math.pow(temp % 10, Integer.toString(n).length());
						temp /= 10;
					}
					return c == n;
				})
				.limit(15)
				.collect(Collectors.toList());
		System.out.println("fr::"+vArmNum);
	}

	private static void sqroot10Prime() {
		List<Double> sqroot= Stream.iterate(1, i->i+1)
				.filter(AddIntArrayList::checkPrimeNumber)
				.map(Math::sqrt)
				.limit(10)
				.collect(Collectors.toList());
		System.out.println(sqroot);
	}

	private static boolean checkPrimeNumber(int x) {
		boolean isPrime= x == 1 || IntStream.range(2, x).noneMatch(i-> x%i==0);
		System.out.println("Prime: "+isPrime);
		return isPrime;
	}

	private static void countOcuuranceOfWords(String vStatement) {
		List<String> vStrList= Arrays.asList(vStatement.split(" "));
		Map<String, Long> vCount= vStrList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(vCount);
		/*
		 * Function<String, String> fn= Function.identity();
		 * System.out.println(fn.apply("hi"));
		 */
	}

	private static void diffBetweenLimitSkip(ArrayList<Integer> vIntArr) {
		System.out.print("All: ");
		vIntArr.stream().forEach(a -> System.out.print(a + ", "));
		System.out.println();
		System.out.print("Limit: ");
		vIntArr.stream().limit(3).forEach(a -> System.out.print(a + ", "));
		System.out.println();
		System.out.print("Skip: ");
		vIntArr.stream().skip(3).forEach(a -> System.out.print(a + ", "));
		System.out.println();
	}

	private static void add2NosByFunctionalInterface(int i, int j) {
		Multiply2Nos vMulti= (a, b) -> a * b;
		System.out.println(vMulti.multiply(6, 7));
	}

	private static void findDuplicateElements(ArrayList<Integer> vIntArr) {
		Set<Integer> vDuplicates= new HashSet<>();
		vIntArr.stream().filter(a -> !vDuplicates.add(a)).collect(Collectors.toSet()).forEach(System.out::println);
	}

	private static void minMaxIntArray(ArrayList<Integer> vIntArr) {
		int vMin= vIntArr.stream().min(Comparator.comparing(Integer::valueOf)).get();
		int vMax= vIntArr.stream().max(Comparator.comparing(Integer::valueOf)).get();
		System.out.println("Min: " + vMin + ", Max: "+ vMax);
	}


	private static void twiceEvenIntArray(ArrayList<Integer> vIntArr) {
		List<Integer> vOthArr= vIntArr.stream().filter(a-> a%2 == 0).map(a-> a*2).collect(Collectors.toList());
		vOthArr.stream().forEach(System.out::println);
		System.out.println(":: Print All");
		vOthArr= vIntArr.stream().map(a-> a%2== 0 ? a*2 : a).collect(Collectors.toList());
		vOthArr.stream().forEach(System.out::println);
	}
	
	private static void addIntArray(ArrayList<Integer> vIntArr) {
		int vSum= vIntArr.stream().reduce((a, b)->a+b).get();
		System.out.println("Sum is: "+vSum);
	}
	

}
