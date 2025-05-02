// https://leetcode.com/problems/robot-bounded-in-circle/description/
// Time Complexity: O(n) 
// Space Complexity: O(1)

class Solution {
    public:
        bool isRobotBounded(string instructions) {
            int n = instructions.size();
            //                             n,     w,       s,     e
            vector<pair<int,int>> dirs = {{0,1}, {-1,0}, {0,-1}, {1,0}};
            int idx=0;
            int x=0; int y=0;
            for(int i=0; i<n; i++){
                if(instructions[i] == 'G'){
                    x += dirs[idx].first;
                    y += dirs[idx].second;
                }else if(instructions[i] == 'L') idx = (idx+1)%4;
                else idx = (idx+3)%4;
            }
            return (x == 0 && y == 0) || idx != 0;
        }
    
    };