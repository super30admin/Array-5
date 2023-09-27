// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

class Solution {
    int[][] dirs = new int[][]{{0,1} , {1,0}, {0,-1} ,{-1,0}};
    public boolean isRobotBounded(String instructions) {
        int x = 0;
        int y = 0;
        int idx = 0;
        //Run the insructions once, if we reach at the starting point, return zero
        //If we are still facing north return false
        for(int i=0; i<instructions.length(); i++){
            char c = instructions.charAt(i);
            if(c == 'G'){
                x = x + dirs[idx][0];
                y = y + dirs[idx][1];
            } else if(c == 'L'){
                idx = (idx + 3)%4;
            } else if(c == 'R'){
                idx = (idx+1)%4;
            }
        }
        if(x ==0 && y ==0) return true;
        return idx!=0;
    }
}