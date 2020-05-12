// Time Complexity: O(logn)
// Space Complexity: O(1)

class Solution {
   private double computeTax(List<List<Double>> levels, double salary) {
       double remainingSalary = salary;
       double tax = 0;
       int currentLevel = 0;
       double prevCap = 0;

       while(remainingSalary > 0) {
        List<Double> bracket = levels.get(currentLevel);
        double percent = bracket.get(1);
        double capValue = bracket.get(0);

        double currentTaxableSalary = Math.min(capValue - prevCap, remainingSalary);

        tax += currentTaxableSalary * percent;

        remainingSalary -= currentTaxableSalary;
        currentTLevel++;
        prevCap = capValue;
       }

       return tax;
   }
}