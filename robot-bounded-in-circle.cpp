// Time Complexity: O(n) n = length of instructions
// Space Complexity: O(1)
class Solution {
public:
    bool isRobotBounded(string instructions) {
        // The 4 directions should be either in clockwise or anticlockwise direction.
                                        // North  West   South    East
        vector<vector<int>> directions = {{0,1}, {-1,0}, {0,-1}, {1,0}};
        int currDir = 0; // initially, the robot faces north
        // initial coordinates
        int x = 0;
        int y = 0;
        for(int i = 0; i < instructions.size(); i++) {
            if(instructions[i] == 'L') {
                currDir = (currDir + 1) % 4;
            }
            else if(instructions[i] == 'R') {
                currDir = (currDir + 3) % 4;
            }
            else { // 'G'
                x += directions[currDir][0];
                y += directions[currDir][1];
            }    
        }
        if(currDir != 0 || (x == 0 && y == 0)) return true;
        return false;
    }
};
