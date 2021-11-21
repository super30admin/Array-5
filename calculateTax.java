// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

public class Main{
    public static double calculateTax(List<List<Double>> levels, double salary){
        double left = salary;
        double tax = 0.0;
        double prevLimit = 0.0;
        int i = 0; // index on levels
        
        while(left > 0){
            List<Double> currlevel = levels.get(i);
            // double currThreshold = level.get(0);
            double taxRate = currlevel.get(1);
            if(currlevel.get(0) == null){
                tax += taxRate * left;
                return tax;
            }
            double taxableSalary = Math.min(left, currlevel.get(0) - prevLimit);
            tax += taxableSalary * taxRate;
            left -= taxableSalary;
            prevLimit = currlevel.get(0);
            
            i++;
        }
        return tax;
    }
    public static void main(String[] args){
        List<List<Double>> levels = new ArrayList<>();
        levels.add( Arrays.asList(10000.0, 0.1) );
        levels.add( Arrays.asList(20000.0, 0.2) );
        levels.add( Arrays.asList(30000.0, 0.3) );
        levels.add( Arrays.asList(null, 0.4) );
        
        double tax = calculateTax(levels, 45000);
        System.out.println(tax);
    }
}