// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
// We will use a directions array to maintain the direction of the robot and keep updating the x and y coordinates , 
// whenever if moves either left or right. When we get 'G', i.e we need to move the robot by one step, we will increment 
// the x and y coordinates refering to the direction in which the robot currently is in. Since the robot keeps following 
// the instructions forever, for it to come back to 0,0 , the maximum repititions needed is 4.

class Solution {
    public boolean isRobotBounded(String instructions) {

                                //N     E       S       W
        int[][]dirs=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int idx=0;
        int x=0, y=0; //to maintain the coordinates
        for(int k=0;k<4;k++)    //to iterate through the directions
        {
            for(int i=0;i<instructions.length();i++)
            {
                char c=instructions.charAt(i);
                if(c=='G')
                {
                    x+=dirs[idx][0];
                    y+=dirs[idx][1];
                }
                else if (c=='L')
                {
                    idx=(idx+3)%4;
                }
                else
                {
                    idx=(idx+1)%4;
                }
            }
            if(x==0 && y==0) return true;
        }
return false;
    }
}