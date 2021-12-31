// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :No(Glassdoor question )
// Any problem you faced while coding this :
//https://www.glassdoor.co.in/Interview/Write-a-program-in-Python-to-calculate-tax-if-Salary-and-Tax-Brackets-are-given-as-list-in-the-form-10000-3-20000-QTN_2565898.htm

// Your code here along with comments explaining your approach
import java.io.*;

import java.util.*;

class GFG {

	public static void main (String[] args) {

		List<List<Double>> levels = new ArrayList<>();

        levels.add( Arrays.asList(10000.0, 0.1) );

        levels.add( Arrays.asList(20000.0, 0.2) );

        levels.add( Arrays.asList(30000.0, 0.3) );

        levels.add( Arrays.asList(null, 0.4) );

        double tax = calculateTax(levels,45000);

        System.out.println(tax);

	}

        public static double calculateTax(List<List<Double>> levels, double salary)
        {
            
            double salaryLeft = salary;

            double Totaltax = 0;

            double prevLimit = 0, percent = 0, currLimit = 0, currRange = 0, currSalary = 0;
            
            
            int i = 0;
            while(salaryLeft>0)
            {
                List<Double> level = levels.get(i);

                i++;

                percent = level.get(1);
                
                
                if(level.get(0) == null){

                    Totaltax += percent* salaryLeft;
                    return Totaltax;
                }
                currLimit = level.get(0);
                
                currRange = currLimit - prevLimit;

                currSalary = Math.min(salaryLeft, currRange);

                Totaltax += currSalary*percent;

                salaryLeft -= currSalary;

                prevLimit = currLimit;
            }

            return Totaltax;
        }

}