// Time Complexity : O(1). as brackets will be constant number like 5.
// Space Complexity : O(1).
// Did this code successfully run on Leetcode : Yes
// Approach : We need to calculate the amount in the first bracket with the first bracket's tax. Later we need to consider the minimum of income left and difference of
// upperi-1 - upperi and apply that specific brackets tax on it. We continue this for the left over income.

class Solution {
    public double calculateTax(int[][] brackets, int income) {
        double tax = 0;
        int i = 0;
        int prevLimit = 0;
        while(income > 0){
            int currLimit = brackets[i][0];
            int percent = brackets[i][1];
            int taxable = Math.min(income, currLimit - prevLimit); //min of income left to be calculated and limit allowed
            tax += (taxable*percent)/100.0;
            income -= taxable; //update the income left to be calculated for tax
            prevLimit = currLimit;
            i++;
        }
        return tax;
    }
}