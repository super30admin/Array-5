// "static void main" must be defined in a public class.
public class CalculateTax {
   
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    
    public static double calculateTax(List<List<Double>> levels, double initSalary ){
        
        Double prev = 0.0;
        Double tax = 0.0;
        Double left = initSalary;

        for(List<Double> level : levels){
            if(left <= 0)
                return tax;
            Double curr = level.get(0);
            Double percentage = level.get(1);
            if(curr == null){
                tax += (left * percentage);
                return tax;
            }
            
            Double taxable = curr - prev;//finding the range
            Double salary = Math.min(taxable, left);//min of salary or range 

            tax += salary * percentage;
            left = left - salary;
            prev = curr;

        }
        return tax;
    }
    
    public static void main(String[] args) {
        List<List<Double>> levels = new ArrayList<>();

        levels.add( Arrays.asList(10000.0, 0.1));

        levels.add( Arrays.asList(20000.0, 0.2));

        levels.add( Arrays.asList(30000.0, 0.3));

        levels.add( Arrays.asList(null, 0.4));

        double tax = calculateTax(levels,45000);

        System.out.println(tax);
    }
}