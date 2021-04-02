// Robot Bounded In Circle
// Time Complexity: O(n) where n = length of instructions
// Space Complexity: O(1)

class Solution {
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // up, right, down, left
    
    public boolean isRobotBounded(String instructions) {      
        int dir = 0;
        int x = 0;
        int y = 0;
        // loop over instructions
        for(int i=0; i<instructions.length(); i++) {
            char c = instructions.charAt(i);
            if (c == 'R') { // right
                dir = (dir + 1) % 4; // to get direction when turned right
            } else if (c == 'L') { // left
                dir = (dir + 3) % 4; // to get direction when turned left
            } else { // G - move 1 step forward in the same direction
                x += dirs[dir][0];
                y += dirs[dir][1];
            }
        }
        // return true if xand y equals 0 or the final direction is not up
        return x == 0 && y == 0 || dir > 0;
    }
}

// Tax Payable
// Time Complexity: O(n) where n = length of levels
// Space Complexity: O(1)

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
    	List<List<Double>> levels = new ArrayList<>();
        levels.add( Arrays.asList(10000.0, 0.3) );
        levels.add( Arrays.asList(20000.0, 0.2) );
        levels.add( Arrays.asList(30000.0, 0.1) );
        levels.add( Arrays.asList(null, 0.1) );
        double tax = calculateTax(levels,45000);
        System.out.println(tax);
    }
    
    private static double calculateTax(List<List<Double>> levels, double salary) {
        double salaryLeft = salary;
        double tax = 0;
        double taxable = 0;
        int i = 0;
        // while condition
        while (salaryLeft > 0) {
            List<Double> level = levels.get(i);
            double percentage = level.get(1);
            // if taxable level is null, need to calculate tax on entire remaining salary
            if (level.get(0) == null) {
                tax += (percentage * salaryLeft);
                break;
            }
            // calculate taxable amount
            taxable = level.get(0) - taxable;
            double currSalary = Math.min(taxable, salaryLeft);
            // calculate tax
            tax += currSalary * percentage;
            // salary left
            salaryLeft -= currSalary;
            taxable = level.get(0);
            i++;
        }
        
        return tax;
    }
}
