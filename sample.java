//Problem 1: Robot bound in a box
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//complete whole instruction and then check if its still facing Initial direction. if yes return false
//if no return true becuase after 3 more such instruction circles, it will come back to origin.
class Solution {
    //O(n) O(1)
    public boolean isRobotBounded(String instructions) {
        int dir[][] = {{0,1}, {-1, 0}, {0, -1}, {1,0}};
        int i = 0;
        int x = 0;
        int y = 0;
       
        for(int s = 0; s < instructions.length(); s++){
            if(instructions.charAt(s) == 'L'){
                i = (i + 1) % 4;
            }
            else if(instructions.charAt(s) == 'R'){
                i = (i + 3) % 4;
            }
            else{
                x = x + dir[i][0];
                y = y + dir[i][1];
            }
        }
        return x == 0 && y == 0 || i != 0;
    }
}

//Problem 2: Calculate tax
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class Solution {
    public double calculateTax(int[][] brackets, int income) {
        int left=income;
        int i=0;
        double TotalTax=0;
        int lower=0;
        while(left>0){
            int[] cur=brackets[i];
            i++;
            int percent=cur[1];
            double taxable=Math.min(left, cur[0]-lower);
            TotalTax+= (taxable*percent)/(double)100;

            left -=taxable;
            lower=cur[0];
        }

        return TotalTax;
    }
}
