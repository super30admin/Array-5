//Time Complexity : O(1) as tax brackets are constant in real world
//Space Complexity : O(1)
//Did this code run successfully on leetcode: Yes
//Have you faced any problem while coding: No
class CalculateTax {
    public double calculateTax(int[][] brackets, int income) {
        int leftAmount = income;
        int lower = 0;
        double tax = 0;
        int idx = 0;
        
        while(leftAmount > 0) {
                int[] br = brackets[idx];
                idx++;
                int upper = br[0];
                int taxPercent = br[1];
                int taxableAmount = Math.min(leftAmount,upper-lower);
                tax += taxableAmount * ((double)taxPercent/100);
                leftAmount = leftAmount - taxableAmount;
                lower = upper;
        }
        return tax;
    }
}