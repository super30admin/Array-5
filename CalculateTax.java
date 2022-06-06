import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Time Complexity : O(n); where n is length of input tax brackets.
//Space Complexity : O(1)
public class CalculateTax { 
	public double calculateTax(List<List<Double>> taxBrackets, double salary) {
		double tax=0;
		double taxableAmt=0;
		double left = salary;
		double prevLimit = 0;		
		int i=0;
		while (left > 0) {
			List<Double> bracket = taxBrackets.get(i);			
			Double currLimit = bracket.get(0);
			double taxRate = bracket.get(1);
			if(currLimit == null) {
				tax += left * taxRate;
				return tax;
			}			
			taxableAmt = Math.min(left, currLimit - prevLimit);
			tax += taxableAmt * taxRate;			
			prevLimit = currLimit;
			left = left - taxableAmt;			
			i++;
		}
		return tax;
	}
	
	// Driver code to test above
	public static void main (String[] args) {	
		CalculateTax ob  = new CalculateTax();	
		double salary = 25000;
		List<List<Double>> taxBrackets = new ArrayList<>();
		taxBrackets.add(Arrays.asList(10000.0, 0.1));
		taxBrackets.add(Arrays.asList(20000.0, 0.2));
		taxBrackets.add(Arrays.asList(30000.0, 0.3));
		taxBrackets.add(Arrays.asList(null, 0.4));
		
		System.out.println("Total tax is: "+ ob.calculateTax(taxBrackets, salary));         
	}	
}
