class CalculateTax {
    public double calculateTax(int[][] brackets, int income) {
        int i=0;
        double tax =0;
        int prevupperbound =0;
        while(income>0)
        {
            int[] curbrac = brackets[i];
            int curupperbound = curbrac[0];
            int percent = curbrac[1];
            double taxableIncomeIncurbracket = Math.min(curupperbound - prevupperbound, income);
            tax += (taxableIncomeIncurbracket*percent)/100d;
            prevupperbound = curupperbound;
            income = (int)(income - taxableIncomeIncurbracket);
            i++;
        }
        return tax;
    }
}

//tc: O(1)
//sc:O(1)
