// Time Complexity: O(n) 
// Space Complexity: O(1)

class Solution {
    public double calculateTax(int[][] brackets, int income) {
        double result = 0.0;
        int lower = 0;
        for (int[] bracket : brackets) {
            int upper = bracket[0];

            int limit = Math.min(upper - lower, income - lower);
            int percent = bracket[1];
            result += (limit * percent) / 100.0;
            lower = upper;
            if (income - lower <= 0)
                break;
        }

        return result;
    }
}