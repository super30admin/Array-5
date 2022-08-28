//Tc - O(n)
//Sc - O(1)
class Solution {
    public double calculateTax(int[][] brackets, int income) {
        double left = income;
        double limit = 0;
        int i = 0;
        double tax = 0;
        
        while(left > 0){
            int[] bracket = brackets[i];
            double percentage = bracket[1];
            double taxable = Math.min(left , bracket[0] - limit);
            tax += taxable * (percentage / 100.00);
            left -= taxable;
            limit = bracket[0];
            i++;
        }
        return tax;
    }
}
