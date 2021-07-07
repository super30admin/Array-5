// Time complexity is O(n)
// Space complexity is O(1)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BigN167SalaryandTaxIterative {
	public double calculateTax(List<List<Double>> levels, double salary) {
		int i = 0;
		double prev = 0;
		double tax = 0;
		while(salary>0) {
			List<Double> level = levels.get(i);
			double percentage = level.get(1);
			if(level.get(0) == null) {
				return tax + salary* percentage;
			}
			double taxableIncome = Math.min(salary, (level.get(0)-prev));
			tax += taxableIncome* percentage;
			salary-=taxableIncome;
			prev = level.get(0);
			i++;
		}
		return tax;
	}
	
	public static void main(String args[]) {
		BigN167SalaryandTaxIterative taxes = new BigN167SalaryandTaxIterative();
		List<List<Double>> levels = new ArrayList<>();
		levels.add(Arrays.asList(10000.0,0.3));
		levels.add(Arrays.asList(20000.0,0.2));
		levels.add(Arrays.asList(30000.0,0.1));
		levels.add(Arrays.asList(null,0.1));
		double salary = 45000;
		System.out.println(taxes.calculateTax(levels, salary));
	}
}