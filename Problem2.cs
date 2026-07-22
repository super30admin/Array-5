// Time Complexity : O(n) where n is the total number of tax brackets (worst case)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*
I maintain variables that store the upper bound of current tax bracket and previous tax bracket as well as the total tax and currentAmount. I initialize i = 0 at first.
I loop through the list of levels till current amount > 0. I set the previous tax bracket to the current bracket and
current bracket to the element at 0th index of ith list. I calculate the taxable amount as the minimum between the difference of previous and current bracket and
the current amount. I calculate the tax as the product of taxable amount and the element at 1st index of ith list. At the end I return the tax.
*/

public class Program
{
    public static void Main(string[] args)
    {
        List<List<double?>> levels = new List<List<double?>>
        {
            new List<double?> { 10000.0, 0.3 },
            new List<double?> { 20000.0, 0.2 },
            new List<double?> { 30000.0, 0.1 },
            new List<double?> { null, 0.1 }
        };

        double tax = CalculateTax(levels, 45000);

        Console.WriteLine(tax);
    }

    public static double CalculateTax(List<List<double?>> levels, double income)
    {
        double tax = 0;
        double currentAmount = income;
        int i = 0;
        double currentBracket = 0, previousBracket = 0;

        while (currentAmount > 0)
        {
            previousBracket = currentBracket;
            currentBracket = levels[i][0] ?? income;

            double taxableAmount = Math.Min((currentBracket - previousBracket), currentAmount);
            currentAmount -= taxableAmount;
            tax += taxableAmount * levels[i][1] ?? 0;
            i++;
        }


        return tax;
    }
}