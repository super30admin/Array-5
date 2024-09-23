//TC = O(1) - because brackets are constant
//SC = O(1)
class CalculateTax {
    public double calculateTax(int[][] brackets, int income) {
        double result = 0.0;
        int idx = 0;
        int lower = 0;
        while(income > 0) {
            int[] currBracket = brackets[idx];
            int upper = currBracket[0];
            int percentage = currBracket[1];
            int taxableIncome = Math.min((upper - lower), income);
            result += (taxableIncome*percentage)/100.00;
            income = income - taxableIncome;
            idx++;
            lower = upper;
        }
        return result;
    }
}