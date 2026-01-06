// Time Complexity : O(1) because we will general have 6-7 bracket in real world
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

/*
Approach
at every brack the amount will be taxed and for the next bracket the taxable income will
be recused by the bracket amount 
*/

class Solution {
    public double calculateTax(int[][] brackets, int income) {
        int i = 0;
        int preLimit = 0;
        double tax = 0;
        while (income > 0) {
            int curLimit = brackets[i][0];
            int percentage = brackets[i][1];
            int taxable = Math.min(income, curLimit - preLimit);
            tax += (taxable * percentage) / 100.0;
            income -= taxable;
            preLimit = curLimit;
            i++;
        }
        return tax;
    }
}