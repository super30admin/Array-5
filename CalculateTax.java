//Time - O(1) - slabs are constant
//Space - O(1)
class Solution {
    public double calculateTax(int[][] brackets, int income) {
        
        int left =income;
        int prev_limit =0;
        double tax=0.0;
        for(int[] slab : brackets){
            int tax_per = slab[1];
            int curr_limit = slab[0];
            tax = tax + (double)Math.min(curr_limit-prev_limit, left)* (double)(tax_per/100.0); 
            left = income-curr_limit;
            prev_limit = curr_limit;
            if(left<0) return tax;
            
        }
        return tax;

    }
}