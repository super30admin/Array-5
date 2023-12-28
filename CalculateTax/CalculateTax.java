/* Time Complexity : O(n)
 * n = length of brackets array */
/* Space Complexity : O(1) */
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

class Solution {
	public static void main (String[] args) {

		List<List<Double>> levels = new ArrayList<>();
		int[][] brackets = new int[][]{{10000, 30},{20000, 20},{30000, 10}};
		int income = 45000;

		double tax = calculateTax(levels, income);

		System.out.println(tax);

	}

	public static double calculateTax(int[][] brackets, int income){
		int i = 0;//idx to iterate over brackets array
		int remainingTaxable = income;
		double tax = 0;
		int prevUpperBound = 0;
		while(remainingTaxable > 0){
			int taxable = Math.min(remainingTaxable, brackets[i][0] - prevUpperBound);
			int percent = brackets[i][0];
			tax += (taxable * percent)/100;
			remainingTaxable = remainingTaxable - taxable;
			prevUpperBound = brackets[i][0];
			i++;
		}
		return tax;
	}
}
