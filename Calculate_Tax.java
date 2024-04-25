class Solution{
    public double calculateTax(int [][]brackets, int income) {
        double tax = 0.0;
        int previouslimit = 0;
        int taxable =0;
        for(int i=0;i<brackets.length;i++) {
            int []currentbracket = brackets[i];
            int currentLimit = currentBracket[0];
            int rate = currentBracket[1]/100;
            taxable = Math.min(currentLimit-previousLimit, income);
            tax = tax+taxable*rate;
            income = income-taxable;
            previouslimit = currentLimit;

        }
        return tax;
    }
}