import java.util.*;

/*
Time Complexity: O(N), N is the number of levels
Space Complexity: O(1)
Run on leetcode: Yes
Any difficulties: no

Approach:
Attempted once discussed in the class
 */
public class CalculateTax {
    public static double calculateTax(List<List<Double>>levels, double salary){
            double remainingSalary = salary;
            double tax = 0;
            double limit = 0;

            int index = 0;

            while(remainingSalary>0){

                List<Double> level = levels.get(index);
                double percent = level.get(1);

                if(level.get(0)== null){
                    tax+= percent*remainingSalary;
                    return tax;
                }

                double currRange = level.get(0) - limit;
                double currSalary = Math.min(remainingSalary, currRange);

                tax+= currSalary*percent;
                remainingSalary-= currSalary;

                limit = level.get(0);
                index++;

            }
            return tax;
    }
    public static void main(String[] args){
        List<List<Double>> levels = new ArrayList<>();
        levels.add( Arrays.asList(10000.0, 0.3) );
        levels.add( Arrays.asList(20000.0, 0.2) );
        levels.add( Arrays.asList(30000.0, 0.1) );
        levels.add( Arrays.asList(null, 0.1) );

        System.out.println(calculateTax(levels,45000));
    }
}
