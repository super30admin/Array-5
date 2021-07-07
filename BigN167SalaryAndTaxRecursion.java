//Time complexity is O(n)
//Space complexity is O(n) i.e recursive stack space

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BigN167SalaryAndTaxRecursion {
	public double calculateTax(List<List<Double>> levels, double salary) {
		return helper(levels,0,salary,0,0);
	}
	
	private double helper(List<List<Double>> levels, double prev, double salary, double tax, int index) {
		// base case
		if(salary<=0) {
			return tax;
		}
		// logic
		List<Double> level = levels.get(index);
		Double percent = level.get(1);
		if(level.get(0) == null) {
			return salary* percent + tax;
		}
		double balance = Math.min(salary, level.get(0) -prev);
		tax += balance * percent;
		prev = level.get(0);
		salary -= balance;
		return helper(levels, prev, salary, tax, index+1);
		
	}
	
	
	public static void main(String args[]) {
		BigN167SalaryAndTaxRecursion taxes = new BigN167SalaryAndTaxRecursion();
		List<List<Double>> levels = new ArrayList<>();
		levels.add(Arrays.asList(10000.0,0.3));
		levels.add(Arrays.asList(20000.0,0.2));
		levels.add(Arrays.asList(30000.0,0.1));
		levels.add(Arrays.asList(null,0.1));
		double salary = 45000;
		System.out.println(taxes.calculateTax(levels, salary));
	}
}
