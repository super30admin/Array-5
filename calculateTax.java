// Time Complexity : O(1), since we are iterating over the number of slabs, but since they are limited we can say
// constant time, otherwise we can say its O(k), where k = no. of tax slabs
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
import java.io.*;
import java.util.*;

class Tax {
    public static void main (String[] args) {
        List<List<Double>> levels = new ArrayList<>();

        levels.add( Arrays.asList(10000.0, 0.3) );
        levels.add( Arrays.asList(20000.0, 0.2) );
        levels.add( Arrays.asList(30000.0, 0.1) );
        levels.add( Arrays.asList(null, 0.1) );

        double tax = calculateTax(levels,45000);
        System.out.println(tax);
    }

    public static double calculateTax(List<List<Double>> levels, double salary){
        if (levels == null || levels.size() == 0) return 0.0;

        int i=0;                   // this is to track next tax slab
        double limit = 0.0;         // used as a marker for previous tax slab
        int total = 0;             // total tax payable
        double remaining = salary; // remaining money

        while (remaining > 0) {
            List<Double> slab = levels.get(i);

            double percent = slab.get(1);
            Double bracket = slab.get(0);
            if (bracket == null) {
                total += remaining*percent;
                break;
            }

            double taxableSalary = Math.min(remaining, bracket-limit);
            total += taxableSalary*percent;
            remaining -= taxableSalary;
            limit = bracket;
            i++;
        }

        return total;
    }
}