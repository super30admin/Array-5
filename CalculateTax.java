// Time Complexity : O(n) n - number of levels
// Space Complexity : O(1)

import java.util.*;

class Genre {
    
    public static double calculateTax(List<List<Double>> levels, double salary ){
        double tax = 0;
        int i = 0;
        double limit = 0;
        double taxable = 0;
        while(salary > 0){
            List<Double> level = levels.get(i);
            if(level.get(0) == null){
                tax += salary * level.get(1);
                return tax;
            }
            limit = level.get(0) - limit;
            taxable = Math.min(salary, limit); 
            tax += taxable * level.get(1);
            salary = salary - limit;
            limit = level.get(0);
            i++;
        }
        return tax;
    }

    public static void main (String[] args) {
    	List<List<Double>> levels = new ArrayList<>();
        levels.add( Arrays.asList(10000.0, 0.1) );
        levels.add( Arrays.asList(20000.0, 0.2) );
        levels.add( Arrays.asList(30000.0, 0.3) );
        levels.add( Arrays.asList(null, 0.4) );
    
        double tax = calculateTax(levels,25000);
        System.out.println(tax);
    }
}