// Time Complexity : O(n) -> O(1)  // less number of range
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

public class CalculateTax {
    public double calculateTax(int[][] brackets, int income) {
        int i=0;
        int leftIncome = income;
        double tax = 0;
        int lower = 0;

        while(leftIncome>0){
            int[] bracket = brackets[i];
            i++;

            int upper = bracket[0];
            int percent = bracket[1];

            int taxable = Math.min(upper - lower, leftIncome);

            tax += (taxable * percent) /(double) 100;

            leftIncome = leftIncome - taxable;
            lower = upper;
        }

        return tax;
    }
}
