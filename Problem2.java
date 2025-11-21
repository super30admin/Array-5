// Time Complexity : O(1) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
//For each tax bracket, calculate how much of the income fits in that range.
//Compute tax for that portion and subtract it from remaining income.
//Repeat until income is taxed fully.

class Solution {
    public double calculateTax(int[][] brackets, int income) {
        int i = 0;
        int prevLimit = 0;
        double tax = 0.0;
        while (income > 0) {
            int curRate = brackets[i][0];
            int curPercent = brackets[i][1];
            int taxable = Math.min(income, curRate - prevLimit);
            tax += (taxable * curPercent) / 100.0;
            income -= taxable;
            prevLimit = curRate;
            i++;
        }
        return tax;
    }
}
