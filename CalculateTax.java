// Time Complexity : O(1),  limited number of tax brackets
// Space Complexity :  O(1) 
// Did this code successfully run on Leetcode : yes
//Approach : Keep finding the range of tax bracket and apply on taxable income.
class Solution {
    public double calculateTax(int[][] brackets, int income) {
        double taxes = 0;

        int tb = 0;
        int prevLimit = 0;

        while(tb < brackets.length && income > 0){
            double taxable = Math.min(income, brackets[tb][0] - prevLimit);
            // System.out.println((50/100));
            taxes += (taxable * (brackets[tb][1]/100.0));

            income -= taxable;

            prevLimit = brackets[tb][0];
            tb++;
        }

        return taxes;
    }
}