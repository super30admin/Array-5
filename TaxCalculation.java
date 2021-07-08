// Time Complexity : O(#tax slabs)
// Space Complexity : O(1) 

// Your code here along with comments explaining your approach (Ex:$25,000 salary)
// we calculate tax as first $10,000 with 10%
// next $10,000 for cap till $20,000 with 20%
// remaining $5000 with 30% 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TaxCalculation {
    static List<List<Double>> levels;

    private static double calculateTax(double salary){
        double tax=0.0;
        double remainingSalary = salary;

        int i=0;
        double prevSlab = 0.0;
        while(remainingSalary>0){
            Double maxInRange = levels.get(i).get(0);
            double percent = levels.get(i).get(1);

            if(maxInRange==null)
                return tax+ remainingSalary*percent;

            double taxableSalary = Math.min(maxInRange - prevSlab, remainingSalary);
            tax += taxableSalary*percent;
            remainingSalary -= taxableSalary;
            prevSlab = maxInRange;
            i++;
        }

        return tax;
    }

    public static void main(String[] args){
        levels = new ArrayList<List<Double>>();
        levels.add(new ArrayList<>(Arrays.asList(10000.0, 0.1)));
        levels.add(new ArrayList<>(Arrays.asList(20000.0, 0.2)));
        levels.add(new ArrayList<>(Arrays.asList(30000.0, 0.3)));
        levels.add(new ArrayList<>(Arrays.asList(null, 0.4)));

        double salary = 25000.0;
        double tax = calculateTax(salary);
        System.out.println("Tax for salary "+salary+" = $"+tax);
    }
}
