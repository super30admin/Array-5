/*
// Time Complexity : O(N)
// Space Complexity :  O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
Try 4 times cause any direction you are except north which is initial direciton you would end up
back if you have net rotation to that direction . 
Moreover after rotation the should also come to [0,0]
*/

#include<iostream>
#include<vector>
#include<string>

using namespace std;

class Solution {
public:
    bool isRobotBounded(string instructions) {
        const int x{0},y{1};
        vector<int> dir{0,1,2,3}; //N E S W
        vector<vector<int>> dirs{
            {0,1}, // N
            {1,0}, // E
            {0,-1},  // S
            {-1,0}}; // W
        
        vector<int> pos{0,0};
        int curr_dir = 0;
        bool flag{false};
        for(int i{};i<4 &&!flag;++i){
            for(const char c:instructions){
                if(c == 'L'){
                    --curr_dir;
                    curr_dir = curr_dir>=0?curr_dir%4:(4+curr_dir)%4;
                }
                else if(c=='R'){
                    curr_dir++;
                    curr_dir = curr_dir>=0?curr_dir%4:(4+curr_dir)%4;
                }
                else if(c == 'G'){
                    pos.at(x) = pos.at(x)+dirs.at(curr_dir).at(x);
                    pos.at(y) = pos.at(y) + dirs.at(curr_dir).at(y);
                }
            }
            if(pos.at(x) == 0 && pos.at(y) == 0 && curr_dir == 0){
                flag = true;
            }
        }
        return flag;
        
    }
};