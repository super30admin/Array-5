// Approach : From the intution of Total Income and Balance income after taxbale amount. We can also keep track of Prev slab
// Time : O(1) // fixed slab rates in real life
// Space : O(1)
// Problem : https://leetcode.com/problems/calculate-amount-paid-in-taxes/
class Solution {
    public double calculateTax(int[][] brackets, int income) {
        int remainingBalance = income; // Initially Income balance before applying any taxes
        int i =0;
        double taxes =0;
        int prevSlab =0;
        while(remainingBalance > 0){
            int[] bracket= brackets[i];
            double percentage = bracket[1]; // 10% , 20 %
            int currSlab = bracket[0]; // 10,000 , 20,000
            int currTaxableIncome = Math.min(remainingBalance,currSlab - prevSlab);
            taxes+=currTaxableIncome * (percentage/100.0);
            remainingBalance = remainingBalance - currTaxableIncome;
            prevSlab=currSlab;
            i++;
        } 

        return taxes;

    }
}