// Time Complexity : O(n)
// Space Complexity :  O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this -

class Solution {
public:
    bool isRobotBounded(string instructions) {

        // Four directions to move in 
        vector<pair<int, int>> dirs;
        dirs.push_back({0,1});
        dirs.push_back({1,0});
        dirs.push_back({0,-1});
        dirs.push_back({-1,0});
        
        int len = instructions.size();
        
        int x = 0;
        int y = 0;
        int j;
        int i = 0;
        
        
        // Complete the travel
        for(j = 0; j < len; j++)
        {
            char c = instructions[j];

            // Change direction based on instruction          
            if(c == 'R')
                i = (i+1) % 4;
            else if(c == 'L')
                i = (i+3) % 4;
            else
            {
                x += dirs[i].first;
                y += dirs[i].second;
            }
        }
        
        // Returned to original position
        return x == 0 && y == 0 || i > 0;
    }
};