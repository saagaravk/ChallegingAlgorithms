package com.sagar.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TestFunction {
	
	static Function<Employee,String> NAMING_FUNCTION  = e->{
		return e.getName();
	};

	public static void main(String[] args) {
		List<Employee> list = new ArrayList<>();
		Employee e1 = new Employee();
		e1.setId(1);
		e1.setName("Sri");
		list.add(e1);
		Employee e2 = new Employee();
		e2.setId(2);
		e2.setName("Srihari");
		list.add(e2);
		Employee e3 = new Employee();
		e3.setId(1);
		e3.setName("SriRam");
		list.add(e3);
		Employee e4 = new Employee();
		e4.setId(1);
		e4.setName("SriNidhi");
		list.add(e4);
		
		System.out.println(list);
		System.out.println(returnNames(list));
		System.out.println(list.stream().map(NAMING_FUNCTION).collect(Collectors.toList()));
	}
	
	public static List<String> returnNames(List<Employee> employees){
		List<String> names = new ArrayList<>();
		for (Employee employee : employees) {
			names.add(employee.getName());
		}
		return names;
	}
}
