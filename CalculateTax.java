// Problem 2303. Calculate Amount Paid in Taxes
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class Solution {
    public double calculateTax(int[][] brackets, int income) {
        double totalTax = 0.0;
        int previousLimit = 0;
        for (int[] bracket : brackets) {
            int upperLimit = bracket[0];
            int percentage = bracket[1];
            int taxableIncome = Math.min(income, upperLimit) - previousLimit;
            if (taxableIncome <= 0) {
                break;
            }
            totalTax += taxableIncome * (percentage / 100.0);
            previousLimit = upperLimit;
        }
        return totalTax;
    }
}