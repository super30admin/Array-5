// Time complexity: O(n)
// Space complexity: O(1)

/*
At the end of the first iteration, if the position is at 0,0 or if the robot is facing any direction excpet North - there exists a circle

If its facing north - then it can just keep moving away 
*/

class Solution {
public:
    bool isRobotBounded(string instructions) {
        if(instructions.length() == 0)
            return true;
        // N E S W
        vector<vector<int>> dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int x=0, y=0, i=0;

        for(char c: instructions) {
            if (c=='G') {
                x = x + dirs[i][0];
                y = y + dirs[i][1];
            }
            else if (c == 'L') {
                i = (i + 1) % 4;
            }
            // +3 because thats how we can get to the index after a right in our dirs array
            else if (c == 'R') {
                i = (i + 3) % 4;
            }
        }
        if((x == 0 && y == 0) || i != 0) {
            return true;
        }
        return false;
    }
};