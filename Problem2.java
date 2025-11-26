/*
2303. Calculate Amount Paid in Taxes
Ran on leetcode: Yes
TC: O(n) SC: O(1)
Calculate the taxed income for each bracket, each bracket has upper limit and percent of tax till that limit, tax the income till that limit if the income is less then only tax the income, and then reduce the income by the taxed income and then repeat using all the brackets of tax till the entire income is taxed
*/
class Solution {
    public double calculateTax(int[][] brackets, int income) {
        
        double tax = 0; // Total tax 
        int lower = 0; // Starting range for the tax
        int idx = 0; // Tax bracket idx

        while(income > 0){
            int upper = brackets[idx][0];
            double taxPercent = brackets[idx][1] / 100.0; 

            int taxedIncome = Math.min(income, upper - lower); // Calculate taxed income, it is either entire income if it is less than the bracket or only portion of the income
            tax += (taxedIncome * taxPercent); // Tax for the bracket

            // Adjust the lower for next tax bracket
            lower = upper;
            // Adjust the income to represent the amount already taxed
            income -= taxedIncome;

            // Move to next tax bracket
            idx++;
        }

        return tax;
    }
}