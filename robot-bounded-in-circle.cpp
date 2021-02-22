//Time - O(n)
//Space - O(1)
class Solution {
public:
    bool isRobotBounded(string instructions) {
        vector<vector<int>> dirs {{0,1},{-1,0},{0,-1},{1,0}};
        int dir = 0;
        int x = 0,y = 0;
        for(auto in:instructions){
            if(in == 'G'){
                x = x+dirs[dir][0];
                y = y+dirs[dir][1];
            }else if(in == 'L'){
                dir = (dir+1)%4;
            }else {
                dir = (dir+3)%4;
            }

        }
        
        return (dir!=0 || x == 0 && y==0);
        
    }
};