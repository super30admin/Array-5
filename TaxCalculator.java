// Time Complexity : O(1) since we have only 4 laps
// Space Complexity : O(1) in place 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Cunning problem in implementation
/* Your code here along with comments explaining your approach: Break the problem. Take the current amount, subtract the previous taken amount. 
Calculate the taxable by multiplying it with the tax % and add the taxable to the tax calculation. If the amount is null, the salary would be taxable
directly with the tax %. Salary is deduced at every iteration by the current since we have calculated tax upto current portion out of salary. 
Display the result as tax.
*/
class Solution{
    public static double calculateTax(List<List<Double>> levels, double salary){
        double tax = 0;
        double prev = 0;
        double taxable = 0;
        if(salary < 0 || levels == null) return tax;
        while(salary > 0){
            for(int i = 1; i  < levels.size(); i++){
                    if(level.get(i).get(0) != null){                                                // If not null
                        amount = level.get(i).get(0) - prev;                                        // Amount is subtract from previous amount (10000)
                    } else {
                        amount = salary;                                                            // For the last lap, take the salary itself
                    }           
                    prev = amount;                                                              // Keep a track of previous amount from levels list
                    current =  Math.min(amount, salary);                                        // Take the minimum of amount and salary left
                    taxable = current * level.get(i).get(1);                                       // calculate taxable amount as per now
                    tax+=taxable;                                                               // Add the amount to your tax
                }
                salary -= current;                                                              // Salary will reduce by current
            }
    return tax;
    }
}