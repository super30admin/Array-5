//Time complexity: O(1) - Only constant number of tax brackets in the real world scenario.
//Space Complexity: O(1) - Constant number or recursive calls.

// Initialize total tax and a lower bound; iterate brackets while income > 0.
// For each bracket, compute taxable = min(income, upper - lower) and add taxable * (percent / 100.0) to tax.
// Update lower = upper and income -= taxable; when income reaches 0, return the accumulated tax.

class Solution {
    public double calculateTax(int[][] brackets, int income) {
        double tax = 0;

        int lower = 0;
        int idx = 0;

        while(income > 0){
            int[] br = brackets[idx];
            idx++;

            int upper = br[0];
            int percent = br[1];

            int taxable = Math.min(income, upper - lower);

            tax += taxable * (percent / 100.00);

            lower = upper;
            income = income - taxable;
        }

        return tax;
    }
}
