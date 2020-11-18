// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

public class Solution {
    
    private double calcTaxes(double salary, double brackets[][]){
        double tax =0;
        for(int i=0; i< brackets.length; i++){
            double currentSal[] = brackets[i];
            double maxRange = currentSal[0];
            
            double salaryOver = Double.min(maxRange, salary);
            double prevSal = 0;
            if(i!=0){
                prevSal = brackets[i-1][0];
            }
            salaryOver = salaryOver - prevSal;
            tax += salaryOver * currentSal[1];
            if (salary < maxRange){
                return tax;
            }   
        }
        return tax;
    }
}