class Solution {
    //TC: O(n)
  //SC: O(1)
    public double calculateTax(int[][] brackets, int income) {
        int  upper1 = 0;
        double tax = 0;
        for(int [] bracket : brackets){
            int percent = bracket[1];
            int upper2 = bracket[0];
            int taxable = Math.min(income,upper2 - upper1);
            tax += (percent * taxable)/100.0;
            income -= taxable;
            upper1 = upper2;
        }
        return tax; 
    }
}
