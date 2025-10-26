public class Solution {
    //For each tax bracket,calculate how much of the income
    // fits in that range until income is taxed fully
    //Time Complexity: O(1)
    //Space Complexity: O(1)
    public double CalculateTax(int[][] brackets, int income )
    {
        double tax = 0;

        int lower = 0;
        int idx = 0;
        while(income>0)
        {
            int[] br = brackets[idx];
            idx++;

            int upper = br[0];
            int percent = br[1];

            int taxable = Math.min(income, upper-lower);

            tax += taxable*(percent/100.00);
            lower = upper;
            income = income-taxable;

        }
        return tax;
    }

}
