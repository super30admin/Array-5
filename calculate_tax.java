// Time Complexity :O(n) ===constant | as there will be fixed no of brackets,where n is no of brackets
// Space Complexity :constant
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No
class Solution {
    public double calculateTax(int[][] brackets, int income) {
        int prevLimit = 0;
        double leftAmt = income;
        double tax = 0.0;
        double result = 0.0;
        // traversing through each bracket
        for (int[] bracket : brackets) {
            int currLimit = bracket[0];
            tax = bracket[1];
            // we'll take min of difference and leftAmount as tehere can be case where
            // amount left is lesser
            double taxableAmt = Math.min(currLimit - prevLimit, leftAmt);
            // calculate amount left after current bracket
            leftAmt -= taxableAmt;
            // calculate amount payable for current bracket
            result += taxableAmt * (tax / 100);
            // update previous limit
            prevLimit = currLimit;
        }
        return result;
    }
}