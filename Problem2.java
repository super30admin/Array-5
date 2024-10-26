// Time Complexity : O(n) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : used the same logic Jaspinder explained in the class.

package Array-5;

public class Problem2 {
    public double calculateTax(int[][] brackets, int income) {
        double res = 0;
        int lower = 0;
        int i = 0;
        while(income > 0){
            int per = brackets[i][1];
            int upper = brackets[i][0];
            int taxableIncome = Math.min(income, upper - lower);
            res = res + (taxableIncome * per) / 100.0;
            income -= taxableIncome;
            lower = upper;
            i++;
        }   
        return res;
    }
}
