class Solution {
    //tc-o(1) as we have max of 8 tax brackets in reality sc-o(1)
    public double calculateTax(int[][] brackets, int income) {
        if(income == 0) return 0;
       // int left = income;
        double taxable = Math.min(brackets[0][0],income);
        int d = brackets[0][1];
        double tax = (taxable *d)/100;
        double left = income-taxable;
        for(int i=1;i<brackets.length;i++)
        {  
            double curr = brackets[i][0];
            double prev = brackets[i-1][0];
            taxable = Math.min(curr-prev, left); //100000
            tax += (taxable *brackets[i][1])/100;
            left = left - taxable;
           
        }
        return tax;
    }
}