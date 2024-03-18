// Time Complexity : O(n)
// Space Complexity : O(1)
// Method used : Arrays

class Solution {
    public boolean isRobotBounded(String instructions) {
        
        // This is because I am already at (0, 0)
        if(instructions == null || instructions.length() == 0) return true;

        // Directions are arranged in clock wise manner(N, E, S, W)
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int i = 0, x = 0, y = 0;

        for(int j = 0; j < instructions.length(); j++)
        {
            char c = instructions.charAt(j);

            // Just keep moving forward in the direction you are
            if(c == 'G')
            {
                x = x + dirs[i][0];
                y = y + dirs[i][1];
            }

            // Just change the direction to right 
            else if(c == 'R') i = (i + 1) % 4;

            // This is a left direction. Assume we are at North and we make a left so we reach west. In the dirs array
            // North index is 0 and west index is 3, that's the reason we do (i + 3) % 4
            else i = (i + 3) % 4;
        }

        // At the end of 1 iteration either I should reach origin or I shouldn't be facing north
        // Reaching (0,0) case is straight forward
        // Assume if we have GL, after 1 iteration we are facing to left but if we repeat it any number of times we will reach to
        // (0, 0) after 4 rotations
        // So even after 1 iteration we are facing north, even after any number of iterations we are never gonna come back to (0,0)
        
        return (x == 0 && y == 0) || (i != 0);
    }
}