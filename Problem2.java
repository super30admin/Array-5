
//Time Complexity: O(M) where M is the number of tax brackets
//Space Complexity: O(1)

//We calculate the tax based on the given brackets and income.
//We iterate through each tax bracket, calculating the taxable income for that bracket
//and adding the corresponding tax to the total tax amount.
//We keep track of the lower limit of the current bracket to determine the taxable income.
//The process continues until the entire income has been taxed.


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
