package com.uma.java8.intrv;

import java.util.ArrayList;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

import com.uma.java8.intrv.dtos.Employee;

public class SortEmployee {

	public static void main(String[] args) {
		List<Employee> vAlEmployee= new ArrayList<>();
		vAlEmployee.add(new Employee(1, "uma", 10000));
		vAlEmployee.add(new Employee(2, "shankar", 7000));
		vAlEmployee.add(new Employee(3, "yadav", 9000));
		vAlEmployee.add(new Employee(4, "sam", 9000));
		vAlEmployee.add(new Employee(5, "singh", 6700));
		vAlEmployee.add(new Employee(6, "yadu", 5555));
		vAlEmployee.add(new Employee(7, null, 5555));
		vAlEmployee.add(new Employee(8, null, 7000));
		
		//sortBySalary(vAlEmployee);
		//salaryLessThan3rdHighest(vAlEmployee);
		//getMinMaxSumSalary(vAlEmployee);
		//High2ndSal(vAlEmployee);
		//CommaSepSal(vAlEmployee);
		//CollectGroupBy(vAlEmployee);
		getNameorDefaultName(vAlEmployee);
	}

	private static void getNameorDefaultName(List<Employee> vAlEmployee) {
		List<String> vNames= vAlEmployee.stream().map(emp-> Optional.ofNullable(emp.getName()).orElse("Default")).collect(Collectors.toList());
		System.out.println(vNames);
		
		vNames= vAlEmployee.stream().map(emp-> Optional.ofNullable(emp.getName()).orElseGet(()->"Default")).collect(Collectors.toList());
		System.out.println(vNames);
		
	}

	private static void CollectGroupBy(List<Employee> vAlEmployee) {
		Map<Object, List<Employee>> vHm= vAlEmployee.stream().collect(Collectors.groupingBy(e-> e.getSalary()));
		System.out.println(vHm);
		Map<Object, Set<Employee>> vHmUniqueSalary= vAlEmployee.stream().collect(Collectors.groupingBy(e-> e.getSalary(), TreeMap::new, Collectors.toSet()));
		System.out.println(vHmUniqueSalary);
	}

	private static void CommaSepSal(List<Employee> vAlEmployee) {
		List<String> names= vAlEmployee.stream().map(a->a.getName()).collect(Collectors.toList());
		String name= names.stream().map(a-> a.toUpperCase()).collect(Collectors.joining(", "));
		System.out.println(name);
	}

	private static void High2ndSal(List<Employee> vAlEmployee) {
		List<Long> vSals= vAlEmployee.stream().map(e->e.getSalary()).sorted((o1, o2)-> (int)(o2-o1)).skip(1).limit(1).collect(Collectors.toList());
		System.out.println(vSals);
	}

	private static void getMinMaxSumSalary(List<Employee> vAlEmployee) {
		List<Long> vSals= vAlEmployee.stream().map(e-> e.getSalary()).collect(Collectors.toList());
		LongSummaryStatistics vSummary= vSals.stream().mapToLong(a->a).summaryStatistics();
		Long min= vSummary.getMin();
		Long max= vSummary.getMax();
		Long sum= vSummary.getSum();
		Long total= vSummary.getCount();
		double avg= vSummary.getAverage();
		System.out.println(min+"::"+max+"::"+sum+"::"+total+"::"+avg);
	}

	private static void salaryLessThan3rdHighest(List<Employee> vAlEmployee) {
		List<Employee> vSortedEmployee= vAlEmployee.stream().sorted((o2, o1) -> (int)(o1.getSalary() - o2.getSalary()))
				.skip(3).collect(Collectors.toList());
		System.out.println(vSortedEmployee);
	}

	private static void sortBySalary(List<Employee> vAlEmployee) {
		List<Employee> vSortedEmployee= vAlEmployee.stream().sorted((o2, o1) -> (int)(o1.getSalary() - o2.getSalary())).collect(Collectors.toList());
		System.out.println(vSortedEmployee);
	}
}
