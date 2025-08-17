// Time Complexity : O(1) //number of brackets is constant
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach : Until income2>current bracket limit, apply percent tax on min(income(if income<bracket_limit), bracket_limit)
/// repeat income2 by current bracket limit, add all taxes we computed at each bracket and return it
class Solution {
    public double calculateTax(int[][] brackets, int income2) {
        double result = 0.0;
        int i=0;
        double income = (double)income2;
        while(income>0){
            int currentUpperBound = brackets[i][0];
            int previousUpperBound = 0;
            if(i>0){
                previousUpperBound = brackets[i-1][0];
            }
            result += Math.min(income, currentUpperBound-previousUpperBound)* brackets[i][1]/100;
            income = income - (currentUpperBound-previousUpperBound);
            System.out.println(income+" "+result);
            i++;
        }
        return result;
    }
}