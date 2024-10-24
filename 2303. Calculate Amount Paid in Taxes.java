class Solution {
    public double calculateTax(int[][] brackets, int income) {

        double taxPaid = 0;
        int rollingSum = 0;
        int prevSum = 0;

        if (income == 0){
            return 0.00000;
        }

        for(int i = 0; i < brackets.length; i++){
            int currBracket = brackets[i][0];

            int taxableAmount = Math.min(income, currBracket) - rollingSum;
            
            int percent = brackets[i][1];
            double p = percent / 100.0;

            if (taxableAmount > 0) {
                taxPaid += taxableAmount * p;
            }

            rollingSum = currBracket;

            if(income <= currBracket){
                break;
            }    

        }
        
        return taxPaid;
    }
}

/// T(C): O(n)
/// S(C): O(1)
