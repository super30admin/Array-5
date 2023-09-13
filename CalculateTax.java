import java.util.Scanner;

public class CalculateTax {

        // Iteration over Array - Time O(1) and Space O(1)

        public double calculateTax(int[][] brackets, int income) {

            double tax = 0;

            // lower limit of the first bracket
            int lower = 0;

            // index iterator
            int i = 0;

            // loop till income is positive
            while(income > 0) {

                // tax percentage in a bracket
                double taxinBracket = brackets[i][1] / 100.0;

                // upper limit of a bracket
                int upper = brackets[i][0];

                // if the last bracket
                if(i == brackets.length - 1) {

                    // add multiplication of remaining income with tax in the last bracket to tax till now
                    tax += income * taxinBracket;

                    // output
                    return tax;
                }

                // income in a bracket
                int incomeInBracket = Math.min(income, upper - lower);

                // multiply tax percentage and income in a bracket and add to tax till now
                tax += taxinBracket * incomeInBracket;

                // current upper will be next lower
                lower = upper;

                // update income by reducing income in last bracket used for tax calculation
                income = income - incomeInBracket;

                // move index ahead
                i++;
            }
            // output
            return tax;
        }

        public static void main(String[] args) {

            CalculateTax obj = new CalculateTax();

            Scanner scanner = new Scanner(System.in);

            System.out.println("number of brackets ");
            int n = scanner.nextInt();

            int[][] brackets = new int[n][2];

            for(int i = 0; i < n; i++) {

                System.out.println("bracket " + (i+1));

                brackets[i][0] = scanner.nextInt();
                brackets[i][1] = scanner.nextInt();
            }

            System.out.println("income ");
            int income = scanner.nextInt();

            double answer = obj.calculateTax(brackets, income);

            System.out.println("the amount of money  to be paid in taxes " + answer);
        }

}

/*
Time Complexity = O(1)

As tax brackets are limited and constant over a period O(n) becomes O(1)

Space Complexity = O(1)
*/