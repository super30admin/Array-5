class Solution {

    //Time Complexity: O(n)
    //Space Complexity: O(1)

    public double calculateTax(int[][] brackets, int income) {

        if(income == 0) return 0;                   //if income is 0 then return 0

        int i = 0;                                  //i is a index pointer that points to the current bracket
        double left = income;                       //left is the income left
        double tax = 0;                             //storing the total tax
        double limit = 0;                           //limit is the amount that we have already paid tax on certain percentage

        while(left > 0){                            //iterate till left is greater than 0

            int[] bracket = brackets[i];            //get the current tax bracket
            double percentage = bracket[1];                                     //get the current tax percentage
            double taxableIncome = Math.min(left, bracket[0] - limit);          //get the taxableIncome by taking min between left and subtraction of bracket[0] - limit
            tax = tax + taxableIncome * (percentage /100.00);                   //multiply the taxableIncome * percentage/100.00 and add it to the tax
            limit = bracket[0];                     //update the limit
            left = left - taxableIncome;            //subtract the taxableIncome from left
            i++;                                    //increament the i
        }
        return tax;                                 //return tax
    }
}

/*
Write a program to calculate tax if Salary and Tax Brackets are given as list in the form [ [10000, .3],[20000, .2], [30000, .1], [None, .1]]. You don’t know in the beginning how many tax brackets are there. You have to test for all of them


class GFG {

    public static double calculateTax(List<List<Double>> levels, double salary ){

        if(income == 0) return 0;                   //if income is 0 then return 0

        int i = 0;                                  //i is a index pointer that points to the current bracket
        double left = income;                       //left is the income left
        double tax = 0;                             //storing the total tax
        double limit = 0;                           //limit is the amount that we have already paid tax on certain percentage

        while(left > 0){                            //iterate till left is greater than 0

            List<Double> bracket = levels.get(i);            //get the current tax bracket

            double percentage = bracket.get(1);                                     //get the current tax percentage

            if(bracket.get(0) == null){                     //check if the bracket.get(0) is null then we just add old tax +  whatever left amount is * percentage

                return tax + (left * percentage);
            }

            double taxableIncome = Math.min(left, bracket.get(0) - limit);          //get the taxableIncome by taking min between left and subtraction of bracket[0] - limit

            tax = tax + taxableIncome * percentage;                   //multiply the taxableIncome * percentage/100.00 and add it to the tax
            limit = bracket.get(0);                     //update the limit
            left = left - taxableIncome;            //subtract the taxableIncome from left
            i++;                                    //increament the i
        }
        return tax;                                 //return tax
    }


    public static void main (String[] args) {

	List<List<Double>> levels = new ArrayList<>();

    levels.add( Arrays.asList(10000.0, 0.3) );
    levels.add( Arrays.asList(20000.0, 0.2) );
    levels.add( Arrays.asList(30000.0, 0.1) );
    levels.add( Arrays.asList(null, 0.1) );

    double tax = calculateTax(levels,45000);

    System.out.println(tax);
    }
}

*/


public class CalculateAmountPaidInTaxesLC2303 {
}
