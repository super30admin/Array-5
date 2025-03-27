class Solution {
    //Time Complexity:(n)
    //Space Complexity:(1)
    public double calculateTax(int[][] brackets, int income) {
        
       double taxed = 0;
        double inc = (double)income;
        double prev = 0;
        for (int i =0; i < brackets.length;i++){
            double bracketIncome = Math.min (inc- prev, brackets[i][0]- prev);
            prev = brackets[i][0];
            taxed += bracketIncome * brackets[i][1] * 0.01;
            if (inc-prev <=0)
            break;
        }

       return taxed;
    }
}
