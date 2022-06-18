package com.uma.java8.intrv;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class ExecuteOperations {

	public static void main(String[] args) {
		ExecuteOperations vExecuteOperations= new ExecuteOperations();
		//vExecuteOperations.javaSingleOpertands();
		//vExecuteOperations.javaBiOpertands();
		//vExecuteOperations.getNewArrayList(10);
		vExecuteOperations.getNewArrayListLimitSkip(10);
		
	}
	
	public void getNewArrayListLimitSkip(int n) {
		ArrayList<Integer> vAl= new ArrayList<>();
		vAl.add(11);vAl.add(15);vAl.add(5);vAl.add(21);vAl.add(5);vAl.add(4);
		System.out.println(vAl);
		List<Integer> vAl2= vAl.stream().limit(2).collect(Collectors.toList());
		List<Integer> vAl3= vAl.stream().skip(2).collect(Collectors.toList());
		List<Integer> vAl4= vAl.stream().distinct().collect(Collectors.toList());
		long vDistinctCount= vAl.stream().distinct().count();
		System.out.println(vAl2+"::"+vAl3+"::"+vAl4+"::"+vDistinctCount);
		vAl.stream().filter(x-> x < 10).forEach(System.out::println);
		
		vAl.stream().map(x-> x<10 ? x*x : x).forEach(System.out::println);
		
	}
	
	public void getNewArrayList(int n) {
		ArrayList<Integer> vAl= new ArrayList<>();
		vAl.add(11);vAl.add(15);vAl.add(5);vAl.add(21);
		System.out.println(vAl);
		List<Integer> vAl2= vAl.stream().filter(i-> i > n).collect(Collectors.toList());
		System.out.println(vAl2);
	}
	
	private void javaBiOpertands() {
		
		Function<Double, Double> vFunc1= i-> i*2;
		BiFunction<Integer, Integer, Double> vBiFunc1= (i, j)-> Math.sqrt(i)/Math.sqrt(j);
		BiFunction<Integer, Integer, Double> vBiFunc2= (i, j)-> i * j * 1.0;
		System.out.println("BiFunction- "+vBiFunc1.andThen(vFunc1).apply(4, 9));
		
		
		BiPredicate<Integer, Integer> vBiPredic2= (i, j)-> i < j && i > 0;
		BiPredicate<Integer, Integer> vBiPredic1= (i, j)-> i < j;
		BiPredicate<Integer, Integer> vBiPredic3= (i, j)-> j > 0;
		System.out.println("BiPredicate- "+vBiPredic1.and(vBiPredic2).test(10, 7));
		System.out.println("BiPredicate- "+vBiPredic1.or(vBiPredic2).test(-6, -5));
		
		
		BiConsumer<Integer, Integer> vBiConsum1= (i, j) -> System.out.println("BiConsumer- "+(i * j));
		vBiConsum1.accept(10, 4);
		
	}
	
	
	
	
	private void javaSingleOpertands() {
		Function<Integer, Integer> vDoubleFunc= i -> 2*i;
		Function<Integer, Integer> vSubFunc= i -> i-2;
		System.out.println("Function: "+vDoubleFunc.andThen(i->i*3).compose(vSubFunc).andThen(i->i-3).apply(3));
		
		Predicate<Integer> vPredc= i -> i < 4;
		System.out.println("Predicate: "+vPredc.test(2));
		System.out.println("Predicate: "+vPredc.test(5));
		
		Consumer<Integer> vConsum1= (i)-> {double r= Math.sqrt(i); System.out.println("Consumer: "+i+"::"+r);};
		Consumer<Integer> vConsum2= (i)-> {double r= i*2; System.out.println("Consumer: "+i+"::"+r);};
		Consumer<Integer> vConsum3= (i)-> {double r= i+3; System.out.println("Consumer: "+i+"::"+r);};
		vConsum1.andThen(vConsum2).andThen(vConsum3).accept(4);
		
		Supplier<LocalDateTime> vSupplier1= () -> LocalDateTime.now();
		System.out.println("Supplier: "+vSupplier1.get());
	}

}
