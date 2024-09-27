import java.util.List;

//time complexity : O(1) because tax slabs are going to be finite
public class CalculateTax {

	public double calculateTax(List<List<Double>> levels, double salary) {

		double tax = 0;
		double left = salary;
		double limit = 0;
		double taxableIncome;

		int i = 0;
		while (left > 0) {
			double percent = levels.get(i).get(1);
			if (levels.get(i).get(0) == null) {
				tax += left * percent / 100;
				return tax;
			}
			taxableIncome = levels.get(i).get(0) - limit;
			tax += (Math.min(left, taxableIncome)) * percent / 100;
			limit = levels.get(i).get(0);
			left = left - taxableIncome;
			i++;
		}
		return tax;

	}
}
