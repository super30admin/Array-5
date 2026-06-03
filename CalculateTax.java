// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
For each tax bracket, calculate how much income fits in that range.Compute tax for that portion and subtract
 it from the remaining income. Repeat until income is taxed fully.
 */
class Solution {
    public double calculateTax(int[][] brackets, int income) {
        double totalTax = 0;
        int prevUpperLimit = 0;

        for(int[] bracket : brackets) {
            int currentUpperLimit = bracket[0];
            double taxPercent = (double)bracket[1] / 100;

            // Stop tracking if we have processed all of the user's income
            if(income <= prevUpperLimit)
                break;

            // Find how much income falls into the current bracket chunk
            int taxableAmount = Math.min(income, currentUpperLimit) - prevUpperLimit;
            totalTax += taxableAmount * taxPercent;

            prevUpperLimit = currentUpperLimit;
        }
        return totalTax;
    }
}