public class CalculateAmountPaidInTaxes {
    public double calculateTax(int[][] brackets, int income) {
        double tax = 0.0;
        int prev = 0;

        for (int[] bracket : brackets) {
            int upper = bracket[0];
            int rate = bracket[1];

            int taxableIncome = Math.min(income, upper) - prev;
            if (taxableIncome > 0) {
                tax += taxableIncome * (rate / 100.0);
                prev = upper;
            }

            if (income <= upper) {
                break;
            }
        }

        return tax;
    }
}
