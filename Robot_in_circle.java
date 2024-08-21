// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public boolean isRobotBounded(String instructions) {
        int dir[][] = {{0,1}, {-1, 0}, {0, -1}, {1,0}}; // N,W,S,E
        int x = 0;
        int y = 0;
        int j = 0;
        for(int i = 0; i< instructions.length(); i++){
            char c = instructions.charAt(i);
            if(c == 'G'){
                x = x + dir[j][0];
                y = y + dir[j][1];
                System.out.println(x);
                System.out.println(y);
            }
            else if(c == 'L'){
                j = (j+1) % 4;
            }
            else{
                j = (j+3) % 4;
            }   
        }

        return (x == 0 && y == 0) || (j != 0);
    }
}