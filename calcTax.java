class Solution {
    public double calculateTax(int[][] brackets, int income) {
        // Tc: O(n) Sc: O(1)
        int tax = 0;

        int prevUpper = 0;

        for (int[] bracket : brackets) {

            int curUpper = bracket[0];
            int perc = bracket[1];

            int curTax = Math.max(0, Math.min(income, curUpper)
                    - prevUpper);

            tax += curTax * perc;

            prevUpper = curUpper;
        }

        return tax / 100.0;

    }
}