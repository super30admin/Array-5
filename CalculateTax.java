/*
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(n)
* 
* Space Complexity: O(1)
* 
*/

public class CalculateTax {
    public double calculateTax(int[][] brackets, int income) {
        double totalTax = 0.0;

        int prevUpper = 0;

        for (int index = 0; income > 0 && index < brackets.length; index++) {
            int currUpper = brackets[index][0];

            int taxPercent = brackets[index][1];

            int amount = Math.min(currUpper - prevUpper, income);

            totalTax += (amount * taxPercent) / 100.0;

            income -= amount;

            prevUpper = currUpper;
        }

        return totalTax;
    }
}
