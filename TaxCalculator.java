import java.io.*;
import java.util.*;
class GFG {
    
	public static void main (String[] args) {
        
		List<List<Double>> levels = new ArrayList<>();
        levels.add(Arrays.asList(10000.0, 0.1));
        levels.add(Arrays.asList(20000.0, 0.2));
        levels.add(Arrays.asList(30000.0, 0.3));
        levels.add(Arrays.asList(null, 0.4));
        
        //double tax = calculateTax(levels,45000);
        double tax = calculateTax(levels,25000);
        
        System.out.println(tax);
	}
    
    //worst case time - O(n) - number of levels
    //space - constant
	public static double calculateTax(List<List<Double>> levels, double salary) {
        double tax = 0.0; //return val - initailly 0
        double prevSlab = 0.0; //initially prev slab is 0
        double remainingAmount = salary;  
        int currentSlab = 0; //start from 1st slab
        
        while(remainingAmount > 0)
        {
            List<Double> current = levels.get(currentSlab); //get the current level
            Double maxInRange = current.get(0); //get the max salary in this level and percent for this level
            double percent = current.get(1);
            
            //if last level is reached, return sum of the tax so far with (current level percent * remaining amount)
            if(maxInRange == null)
            {
                return tax + remainingAmount * percent; 
            }
            
            //find salary that is taxable in current range
            //add that (salary * percent of current level) with tax so far
            //update prev slab with current level and remaining amount becomes remaining amount - salary taxed in this level
            //go to next level
            double taxableSalary = Math.min(maxInRange - prevSlab, remainingAmount);
            tax += percent * taxableSalary;
            prevSlab = maxInRange;
            remainingAmount -= taxableSalary;
            currentSlab++;
        }
        
        return tax;
    }
}
