/*Time Complexity: O(len of inst)

Space Complexity: O(1) 

Did this code successfully run on Leetcode : Yes

Approach: Using the dirs array keep rotating and finally check if we meet at origin again.

Prob: 1041. Robot Bounded In Circle
*/

class Solution {
    public boolean isRobotBounded(String instructions) {
        int n = instructions.length();
                                    //N     W     S     E
        int [][] dirs = new int[][] {{0,1},{1,0},{0,-1},{-1,0}};
        int idx = 0;
        int x=0;
        int y=0;
        for(int k=0;k<4;k++){
            for(int i=0;i<n;i++){
                char c = instructions.charAt(i);
                if(c == 'L'){
                    idx = (idx+3)%4;
                }
                else if(c == 'R'){
                    idx = (idx+1)%4;
                }
                else{
                    x += dirs[idx][0];
                    y += dirs[idx][1];
                }
            }
            if(x == 0 && y == 0) return true;
        }
        return false;
    }
}