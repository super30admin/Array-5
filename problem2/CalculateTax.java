// Time Complexity : O(n), n -> Number of tax levels
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalculateTax {
	public static double calculateTax(List<List<Double>> levels, double salary) {
		if (levels == null || levels.size() == 0) {
			return 0.0;
		}

		double tax = 0;
		double taxable = 0;
		double limit = 0;

		int idx = 0;

		while (salary > 0) {
			List<Double> level = levels.get(idx);
			Double currLimit = level.get(0);
			double taxPercentage = level.get(1);
			// currLimit is null
			if (currLimit == null) {
				tax += salary * taxPercentage;
				salary = 0;
			}
			// currLimit is not null
			else {
				taxable = Math.min(salary, currLimit - limit);
				tax += taxable * taxPercentage;
				salary -= taxable;
				limit = currLimit;
			}
			idx++;
		}

		return tax;
	}

	public static void main(String[] args) {
		List<List<Double>> levels = new ArrayList<>();

		levels.add(Arrays.asList(10000.0, 0.4));
		levels.add(Arrays.asList(20000.0, 0.3));
		levels.add(Arrays.asList(30000.0, 0.2));
		levels.add(Arrays.asList(null, 0.1));

		double salary = 45000;
		double tax = calculateTax(levels, salary);

		System.out.println("Tax: " + tax);

	}

}
