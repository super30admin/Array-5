
//TC - O(1), as in real world scenario, the tax slabs would be a constant
//SC - O(1)
import java.util.*;

public class calculate_tax {

	public static void main(String[] args) {

		List<List<Double>> levels = new ArrayList<>();

		levels.add(Arrays.asList(10000.0, 0.3));

		levels.add(Arrays.asList(20000.0, 0.2));

		levels.add(Arrays.asList(30000.0, 0.1));

		levels.add(Arrays.asList(null, 0.1));

		double tax = calculateTax(levels, 45000);

		System.out.println(tax);

	}

	public static double calculateTax(List<List<Double>> levels, double salary) {
		double tax = 0;
		double limit = 0;
		int i = 0;
		double left = salary;
		while (left > 0) {
			List<Double> list = levels.get(i);
			double percent = list.get(1);
			if (list.get(0) == null) {
				tax += percent * left;
				return tax;
			}
			double taxableSalary = Math.min(list.get(0) - limit, left);
			tax += taxableSalary * percent;
			limit = list.get(0);
			left = left - taxableSalary;
			i++;
		}
		return tax;
	}
}
