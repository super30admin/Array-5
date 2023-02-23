//https://leetcode.com/problems/calculate-amount-paid-in-taxes
//TC: O(n)
//SC: O(1)


class Solution {
    public double calculateTax(int[][] brackets, int income) {
        int slabs = brackets.length;
        double tax = 0;
        int limit = 0;
        for(int i=0;income > 0;i++){
            int[] slab = brackets[i];
            double taxPercent = slab[1];
            int uLimit = slab[0];
            if(i==slabs){
                tax += income * taxPercent / 100;
                return tax;
            }
            int taxable = Math.min(income,uLimit-limit);
            tax += taxable * taxPercent / 100;
            limit = uLimit;
            income = income - taxable;
        }
        return tax;
    }
}
