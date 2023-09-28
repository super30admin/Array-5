// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

class Solution {
    public double calculateTax(int[][] brackets, int income) {
        int len = brackets.length;
        int i = 0;
        double result = 0.0;
        //Go through all the brackets which are less than the income and calculate result
        while(brackets[i][0] <= income){
            if(i == 0) result = result + (brackets[i][1]/(double)100)*brackets[i][0];
            else result = result + (brackets[i][1]/(double)100)*(brackets[i][0] - brackets[i-1][0]);
            if(i == brackets.length-1) return result;
            i++;
        }

        
        if(i == 0) result = result + (brackets[i][1]/(double)100)*income;
        else result = result + (brackets[i][1]/(double)100)*(income - brackets[i-1][0]);
        return result;

    }
}