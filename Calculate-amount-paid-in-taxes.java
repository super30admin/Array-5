/*Time Complexity: O(N)

Space Complexity: O(1) 

Did this code successfully run on Leetcode : Yes

Approach: Calculate the taxes based on slabs.

Prob: 2303. Calculate Amount Paid in Taxes
*/

class Solution {
    public double calculateTax(int[][] brackets, int income) {
        int upper1 = 0;
        double tax = 0.0;
        for(int []bracket : brackets){
            int percent = bracket[1];
            int upper2 = bracket[0];
            int taxable = Math.min(income,upper2-upper1);
            tax += (taxable*percent)/100.0;
            upper1 = upper2;
            income -= taxable;
        }
        return tax;
    }
}