// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
// We will iterate through brackets and calculate the taxable amount for it by subtracting the current amount with the previous amount. By subtracing this value from the 
// income would give us the amount left, which can be taken to another bracket. While calculating the taxable amount, we will take the minimum between the amount left and 
// the difference between current and previous bracket amount. 

class Solution {
    public double calculateTax(int[][] brackets, int income) 
    {
    int left=income,i=0;
    double tax=0;
    int lower=0;    //this is to maintain the value of the previous bracket

    //until the income becomes 0 we will keep calculating
    while(left>0)
    {
        //taking one bracket at a time;
        int[]bracket=brackets[i];
        i++;
        int upper=bracket[0];
        double percent=bracket[1];
        double taxable= Math.min(left,upper-lower);
        tax+=taxable*(percent/100);
        left-=taxable; //deduct the taxable amount from left, so we can take it to the next bracket
        lower=upper;    //making the current value as the lower value for the next bracket
    }
return tax;
    }
}