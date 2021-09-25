# Array-5

## Problem1: Bind Robot in a Circle (https://leetcode.com/problems/robot-bounded-in-circle/)

// Time - Complexity = O(N)
// Space - Complexity = O(1)

class Solution {
public boolean isRobotBounded(String instructions) {
if(instructions == null || instructions.length() == 0) {
return true;
}

        int[][] dirs = new int[][] {{0,1},{1,0},{0,-1},{-1,0}};
        int dir = 0;
        int x = 0;
        int y = 0;
        for(int i = 0 ;i < instructions.length(); i++) {
            char c = instructions.charAt(i);

            if(c == 'G') {
                x+= dirs[dir][0];
                y+= dirs[dir][1];
            } else if(c == 'L') {
                dir = (dir + 3) % 4;
            } else {
                dir = (dir + 1) % 4;
            }
        }
        return (x == 0 && y == 0 ) || dir != 0;
    }

}

## Problem2: Calculate Tax

Write a program to calculate tax if Salary and Tax Brackets are given as list in the form [ [10000, .3],[20000, .2], [30000, .1], [None, .1]]. You don’t know in the beginning how many tax brackets are there. You have to test for all of them

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

    public static double calculateTax(List<List<Double>> levels, double salary ){


    }

}

// "static void main" must be defined in a public class.
public class Main {
public static void main (String[] args) {

    List<List<Double>> levels = new ArrayList<>();

    levels.add( Arrays.asList(10000.0, 0.4) );

    levels.add( Arrays.asList(20000.0, 0.3) );

    levels.add( Arrays.asList(30000.0, 0.2) );

    levels.add( Arrays.asList(null, 0.1) );

    double tax = calculateTax(levels,45000);
    double tax2 = calculateTax(levels,25000);

    System.out.println(tax);
    System.out.println(tax2);

}

    public static double calculateTax(List<List<Double>> levels, double salary ){
        if(levels == null || levels.size() == 0) {
            return 0;
        }

        double pendingSalary = salary;
        double limit = 0;
        double taxable = 0;
        double tax = 0;
        int idx = 0;

        while(pendingSalary > 0) {
            Double currentLimit = levels.get(idx).get(0);
            double percentage = levels.get(idx).get(1);

            if(currentLimit == null) {
                tax += percentage * pendingSalary;
                return tax;
            }
            taxable = Math.min(pendingSalary, currentLimit-limit);
            tax += percentage * taxable;
            pendingSalary -= taxable;
            limit = currentLimit;
            idx++;
        }
        return tax;
    }

}
