//time complexity- O(n)
//space complexity- O(1)
import java.util.*;
public class CalculateTax {
    static double calculateTax(int[][] brackets, int income) {
        double tax= 0;
        int n = brackets.length;
        int prev = 0;
        for (int i = 0; i < n; i++) {
            if (income > brackets[i][0]) {
                tax += (brackets[i][0] - prev) * (brackets[i][1] / 100.0);
                prev = brackets[i][0];
            } else {
                tax += (income - prev) * (brackets[i][1] / 100.0);
                break;
            }
        }
        return tax;
    }
    public static void main (String[] args) {
        int[][] brackets = {{3,50},{7,10},{12,25}};
        int income = 10;
        double tax = calculateTax(brackets, income);
        System.out.println("Tax on income "+ income + " is " + tax);
    }
}
