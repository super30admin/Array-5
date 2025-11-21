/*
* Approach: Iterative
- The idea is to have find out the income that fits in each tax bracket i.e taxable income
- calculate the tax amount on the taxable income and subtract the taxable income from the actual income
- continue until entire income is taxed
- TC: O(1) -> limited tax brackets in real life
- SC: O(1) -> no additional space used
 */
class Solution {
    public double calculateTax(int[][] brackets, int income) {
        int i = 0;
        double tax = 0.0;
        int prevLimit = 0;

        while(income > 0){
            //get currentrate and limit
            int currrate = brackets[i][1];
            int currLimit = brackets[i][0];
            
            int taxable = Math.min(income, currLimit - prevLimit);
            tax = tax + (taxable * currrate)/100.0;
            prevLimit = currLimit;
            income -= taxable; 
            i++;
        }
        return tax;
    }
}