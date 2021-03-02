// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NA


// Your code here along with comments explaining your approach

// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        
        List<List<Double>> levels = new ArrayList<>();
        
        levels.add(Arrays.asList(10000.0, 0.1));
        levels.add(Arrays.asList(20000.0, 0.2));
        levels.add(Arrays.asList(30000.0, 0.3));
        levels.add(Arrays.asList(null, 0.4));
        
        System.out.println(calculateTax(levels, 45000));
    }
    
    private static double calculateTax(List<List<Double>> levels, double salary) {
        
        double left = salary;
        double limit = 0.0;
        double tax = 0.0;
        
        int i = 0;
        
        while(left > 0) {
            
            List<Double> level = levels.get(i);
            double percent = level.get(1);
            
            if(level.get(0) == null) {
                tax += left * percent;
                return tax;
            }
            
            double taxableIncome = Math.min(left, level.get(0) - limit);
            tax += taxableIncome * percent;
            limit = level.get(0);
            left = left - taxableIncome;
            i++;
        }
        return tax;
    }
}