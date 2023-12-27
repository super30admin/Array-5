// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class CalculateTax {
    class Solution {
        public double calculateTax(int[][] brackets, int income) {
            double tax = 0.0;
            int remaining = income;
            int m = brackets.length;
            int prev = 0;

            for(int i = 0; i < m; i++){
                int taxable = Math.min(brackets[i][0] - prev, remaining);
                System.out.println(taxable);
                tax += (taxable * brackets[i][1]) / 100.0;
                prev = brackets[i][0];
                remaining = remaining - taxable;
            }

            return tax;
        }
    }
}
