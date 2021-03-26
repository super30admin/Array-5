// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
     List<List<Double>> levels = new ArrayList<>();

    levels.add( Arrays.asList(10000.0, 0.3) );

    levels.add( Arrays.asList(20000.0, 0.2) );

    levels.add( Arrays.asList(30000.0, 0.1) );

    levels.add( Arrays.asList(null, 0.1) );

    double tax = calculateTax(levels,25000);

    System.out.println(tax);
    }
//TC:O(N)
//SC:O(1)
//Dit it run successfully on Leetcode? : Yes
  public static double calculateTax(List<List<Double>> levels, double salary ){
    double leftSalary = salary;
    double prevSlab = 0;
    double tax = 0;
    int i = 0;
    while (leftSalary > 0){
        List<Double> level = levels.get(i);
        double percent = level.get(1);
        if (level.get(0) == null){
            tax += leftSalary * percent;
            return tax;
        }
        double currentSlab = level.get(0);
        double taxableSalary = Math.min(leftSalary, currentSlab -  prevSlab);
        tax += taxableSalary * percent;
        prevSlab = currentSlab;
        leftSalary = leftSalary - taxableSalary;
        i++;
    }
    return tax;
 }
}
