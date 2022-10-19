import java.util.ArrayList;
import java.util.List;

// Time Complexity : O(n) where n = length of brackets
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
//2303. Calculate Amount Paid in Taxes (Easy) - https://leetcode.com/problems/calculate-amount-paid-in-taxes/
// Time Complexity : O(n) where n = length of brackets
// Space Complexity : O(1)
class Solution {
	public double calculateTax(int[][] brackets, int income) {
		double tax = 0;
		int i = 0;
		int pendingSalary = income;
		int prev = 0;

		while (pendingSalary > 0) {
			int[] bracket = brackets[i];
			int curr = bracket[0];
			int percent = bracket[1];

			double taxableIncome = Math.min(pendingSalary, (curr - prev));
			tax += taxableIncome * (percent / 100.0);
			pendingSalary -= (curr - prev);
			i++;
			prev = curr;
		}

		return tax;
	}
}