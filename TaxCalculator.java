// Problem Type: Array - 5
// LeetCode - 2303

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
/**
 * Algo:
 * 
 * a. Break the income into slabs such that pick the Math.min(remainingIncome, (currUpperBound - prevUpperBound)) as the current slab's taxable income
 */
/**
 * TC: If # of tax brackets are considered to be constant, then O(1)
 * else, O(n)
 */
/*
 * SC: O(1)
 */

public class TaxCalculator {
    
    public double calculateTax(int[][] brackets, int income) {
        int remIncome = income;
        double tax = 0;
        int prevBound = 0;
        int i = 0;
        int currIncome = 0;

        while(remIncome > 0) {
            currIncome = Math.min((brackets[i][0] - prevBound), remIncome);
            tax += currIncome * brackets[i][1] * 0.01;
            remIncome -= currIncome;
            prevBound = brackets[i][0];
            i++;
        }

        return tax;
    }
    
}