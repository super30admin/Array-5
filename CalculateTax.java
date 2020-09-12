// Time Complexity : O(n) 
// Space Complexity : O(1)

import java.util.*;

class calculateTax {

	public static double calculateTax(List<List<Double>> levels, double salary) {
		int i = 0;
		double tax = 0, prev = 0;
		while (salary > 0) {
			List<Double> level = levels.get(i);
			double percent = level.get(1);
			if (level.get(0) == null) {
				return tax + percent * salary;
			}
			double taxableIncome = Math.min(salary, level.get(0) - prev);
			tax += taxableIncome * percent;
			salary -= taxableIncome;
			prev = level.get(0);
			i++;
		}
		return tax;
	}

	public static void main(String[] args) {
		List<List<Double>> brackets = new ArrayList<>();
		brackets.add(Arrays.asList(10000.0, 0.3));
		brackets.add(Arrays.asList(20000.0, 0.2));
		brackets.add(Arrays.asList(30000.0, 0.1));
		brackets.add(Arrays.asList(null, 0.1));	
		System.out.println(calculateTax(brackets, 45000));
	}
}
