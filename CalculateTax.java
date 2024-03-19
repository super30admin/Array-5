public class CalculateTax {
    // TC: O(N) where N is length of brackets
    // SC: O(1)
    public double calculateTax(int[][] brackets, int income) {
        double result = 0.0;
        int upper = 0;
        for (int [] bracket : brackets) {
            int bracketIncome = bracket[0];
            int percentage = bracket[1];
            int taxableIncome = Math.min(income, bracketIncome - upper);
            income -= taxableIncome;
            upper = bracketIncome;
            result += (taxableIncome * percentage) / 100.0;
        }
        return result;
    }
}
