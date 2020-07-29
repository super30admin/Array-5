//Let n is the number of tax levels 
//time complexity O(n) => O(1) since n is constant in real world
//space complexity O(1)

// "static void main" must be defined in a public class.
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        List<List<Double>> levels = new ArrayList<>();
        levels.add(Arrays.asList(10000.0, 0.1));
        levels.add(Arrays.asList(20000.0, 0.2));
        levels.add(Arrays.asList(30000.0, 0.3));
        levels.add(Arrays.asList(null, 0.4));
        double tax = calculateTax(levels, 5000);
        System.out.println(tax);
    }

    public static double calculateTax(List<List<Double>> levels, double salary){
        int index = 0;
        double prev = 0;
        double left = salary;
        double tax = 0;
        while(left > 0){
            List<Double> currLevel = levels.get(index);
            Double ceiling = currLevel.get(0);
            Double perc = currLevel.get(1);
            if(ceiling == null){
                tax += left * perc;
                return tax;
            }
            Double taxable = Math.min(ceiling - prev, left);
            tax += taxable * perc;
            left = left - taxable;
            prev = ceiling;
            index++;
        }
        return tax;
    }
}
