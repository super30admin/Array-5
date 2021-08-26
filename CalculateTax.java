package Array5;

//TC : o(1) tax slabs are constant
//SC : o(1)
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalculateTax {
	public static void main (String[] args) {

		List<List<Double>> levels = new ArrayList<>();

	    levels.add( Arrays.asList(10000.0, 0.1) );

	    levels.add( Arrays.asList(20000.0, 0.2) );

	    levels.add( Arrays.asList(30000.0, 0.3) );

	    levels.add( Arrays.asList(null, 0.4) );

	    double tax = calculateTax(levels,45000);

	    System.out.println(tax);

	}

	public static double calculateTax(List<List<Double>> levels, double salary ){
		double tax = 0;
		int i = 0;
		double remainingSalary = salary;
		double taxable;
		double limit = 0;
		
		while(remainingSalary > 0) {
			List<Double> level = levels.get(i);
			double percentage = level.get(1);
			if(level.get(0) == null) {
				tax += remainingSalary * percentage;
				return tax;
			}
			taxable = Math.min(remainingSalary, level.get(0)-limit);
			tax+=taxable*percentage;
			remainingSalary -=taxable;
			limit = level.get(0);
			i++;
		}
		return tax;
	}

}
