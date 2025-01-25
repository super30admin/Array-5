class Problem2 {
    public double calculateTax(int[][] brackets, int income) {
        int idx = 0;
        double tax = 0;
        int upper = 0;
        int lower = 0;
        while(income > 0 && idx<brackets.length){
            int [] bracket =  brackets[idx]; // [[3,50],[7,10],[12,25]]
            upper = bracket[0];//3
            int taxPercent = bracket[1];//50

            int taxableAmt =  Math.min(income,upper-lower);
            tax = tax + (taxableAmt*taxPercent/100D);
            lower = upper;

            income = income - taxableAmt;
            idx++;
        }

        return tax;
    }
}