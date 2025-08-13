// Time Complexity
// O(B) where B = number of brackets (single pass).

// Space Complexity
// O(1) auxiliary space.

// Approach (3 steps)
// Iterate brackets in order (keep previous upper bound implicitly via i-1).

// Compute taxable slice: limit = min(remaining income, upper - prevUpper) and multiply by the bracket rate.

// Accumulate & advance: add to tax, subtract limit from income, move to next bracket; stop when income == 0 or brackets end.

class Solution {
    public double calculateTax(int[][] brackets, int income) {
        double tax = 0.0;
        int i=0;
        while(income > 0){
            double percentage = brackets[i][1]/100.0;
            int limit = brackets[i][0];
            if(i > 0){
                limit = Math.min(income , brackets[i][0] - brackets[i-1][0]);
            }
            limit = Math.min(income ,limit);
            tax += limit * percentage;
            income -= limit;
            i++;
        }
        return tax;
    }
}
