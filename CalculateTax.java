// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalculateTax {
    public static void main (String[] args) {

        List<List<Double>> levels = new ArrayList<>();
        levels.add( Arrays.asList(10000.0, 0.1) );
        levels.add( Arrays.asList(20000.0, 0.2) );
        levels.add( Arrays.asList(30000.0, 0.3) );
        levels.add( Arrays.asList(null, 0.4) );
        double tax = calculateTax(levels,45000);
        System.out.println(tax);
    }

    public static double calculateTax(List<List<Double>> levels, double salary ) {
        double totalTax = 0; //0
        double prevLimit = 0; //0
        double leftOverAmount = salary;
        for(List<Double> level : levels) { // [30000, 0.3]
            if(level.get(0) ==  null) {
                totalTax += leftOverAmount * level.get(1);
                return totalTax;
            }
            double range = level.get(0) - prevLimit; //10000
            double taxableAmount = Math.min(leftOverAmount, range); //10000
            totalTax += (taxableAmount * level.get(1)); //1000 + 2000
            leftOverAmount = leftOverAmount - taxableAmount;
            prevLimit = level.get(0); // 20000
        }
        return totalTax;
    }
}
