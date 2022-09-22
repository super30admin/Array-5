// Time Complexity : O(n) n is no of brackets
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class Solution {
    public double calculateTax(int[][] brackets, int income) {
        double amount = 0;
        int start = 0;
        for(int i=0;i<brackets.length;i++){
            if(income>0 && income-start>=brackets[i][0]-start){
                amount += (double)(brackets[i][0]-start)*brackets[i][1]/100;
                start = brackets[i][0];
                income -= brackets[i][0]-start;
            }
            else if(income>0 && income-start<brackets[i][0]-start){
                amount += (double)(income-start)*brackets[i][1]/100;
                start = brackets[i][0];
                income = 0;
            }
        }
        return amount;
    }
}