// Time Complexity: O(n), where n is the length of the instructions string.
// Space Complexity: O(1), as we are using a constant amount of space for variables.
// Did this code run successfully on LeetCode: Yes

//Approach: 
// 1. The robot can move in four directions: North, West, South, and East.
// 2. The robot starts facing North and can turn left or right.
// 3. The robot is bounded in a circle if after executing the instructions, it returns to the origin (0, 0) or if it is not facing North.

class Solution {
public:
    bool isRobotBounded(string instructions) {
        vector<vector<int>> directions = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}}; // N, W, S, E
        int index = 0; //direction index in dirs array
        int x = 0; int y = 0; 
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < instructions.size(); j++){
                char ch = instructions[j];
                if(ch == 'G'){
                    x += directions[index][0];
                    y += directions[index][1];
                } else if(ch == 'L'){
                    index = (index + 1) % 4;
                } else{
                    index = (index + 3) % 4;
                }
            }
            //After set of instructions 4 times, if at origin then circle
            if(x == 0 && y == 0){
                return true;
            }
        }
        return false;
    }
};