package com.example.problems;

import java.util.*;
/*
Time Complexity: O(N) 
Space Complexity: O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
*/


public class CalculateTax {

	public static void main(String args[]) {
		List<List<Double>> levels = new ArrayList<>();

		levels.add(Arrays.asList(10000.00, 0.3));
		levels.add(Arrays.asList(20000.00, 0.2));
		levels.add(Arrays.asList(30000.00, 0.1));
		levels.add(Arrays.asList(null, 0.1));
		System.out.println(calculateTax(levels,25000));

		System.out.println(calculateTax(levels,45000));
	}

	public static double calculateTax(List<List<Double>> levels, double salary) {
		double tax = 0.0,prev= 0.0;
		int index = 0;
		while (salary > 0) {
			List<Double> level = levels.get(index);
			double percent = level.get(1);
			if (level.get(0) == null) {
				return tax + salary * percent;
			}
			double taxIncome = Math.min(salary, level.get(0) - prev);
			tax += taxIncome * percent;
			salary -= taxIncome;
			prev = level.get(0);
			index++;
		}
		return tax;
	}
}
