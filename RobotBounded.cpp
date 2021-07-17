/*
Intuition: If the robot returns to its original position or if it is on it its original direction,
then the robot moves in a circle.

Simulate the robot position using a dirs array
Time Complexity: O(N), N = length of the instruction
Space Complexity: O(1)

*/
class Solution {
public:
    bool isRobotBounded(string instructions) {
        int currDirection = 0;
        int x = 0; int y = 0;
        vector<vector<int>> dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        for ( auto command: instructions){
            if ( command == 'L'){
                currDirection = (currDirection + 3) % 4;
            }
            else if ( command == 'R'){
                currDirection = (currDirection + 1) % 4;
            }
            else{
                x += dirs[currDirection][0];
                y += dirs[currDirection][1];
            }
        }
        return ( x== 0 and y == 0 ) or currDirection != 0;
    }
};