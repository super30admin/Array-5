// Time Complexity : O(n)
// Space Complexity : O(1)

import java.util.*;

class GFG {

    public static void main(String[] args) {
        List<List<Double>> levels = new ArrayList<>();
        levels.add(Arrays.asList(10000.0, 0.3));
        levels.add(Arrays.asList(20000.0, 0.2));
        levels.add(Arrays.asList(30000.0, 0.1));
        levels.add(Arrays.asList(null, 0.1));
        
        double tax = calculateTax(levels, 45000);
        System.out.println(tax);
    }

    public static double calculateTax(List<List<Double>> levels, double salary) {
        double tax = 0;
        double previousLevel = 0;
        
        for (List<Double> level : levels) {
            if (level.get(0) == null || salary <= level.get(0)) {
                tax += (salary - previousLevel) * level.get(1);
                break;
            } else {
                tax += (level.get(0) - previousLevel) * level.get(1);
                previousLevel = level.get(0);
            }
        }
        
        return tax;
    }
}

