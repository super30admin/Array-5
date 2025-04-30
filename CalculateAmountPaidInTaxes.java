//In this approach, we iterate through the income and calculate tax as per the bracket it falls into and return the result at the end
//Time Complexity: O(1) since we have only limited tax brackets
//Space Complexity: O(1)
class Solution {
    public double calculateTax(int[][] brackets, int income) {
        double tax = 0;
        int i = 0;
        int prevUpperBound = 0;
        while(income > 0){
            int[] currBracket = brackets[i];
            int currUpperBound = currBracket[0];
            int currTaxPercent = currBracket[1];
            int taxableIncomeInCurrBracket = Math.min((currUpperBound - prevUpperBound), income);            
            tax += taxableIncomeInCurrBracket * currTaxPercent / 100d;
            income = income - taxableIncomeInCurrBracket;
            prevUpperBound = currUpperBound ;
            i++;
        }
        return tax;
    }
}