/**
 * Calculates total tax based on given tax brackets and income.
 * Iteratively applies each bracket's rate to the portion of income that falls within it.
 * Returns the computed tax as a double.
 */
// Time Complexity: O(N), where N is the number of tax brackets
// Space Complexity: O(1), as only constant extra variables are used
public class Calculatetax {

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
