class Solution {
public:
    
    vector<vector<int>> dir = {{0,1},{1,0},{0,-1},{-1,0}};
    
    int x = 0, y = 0;
    int d = 0;

    void move(char &c){
        if(c == 'G')  x += dir[d][0], y += dir[d][1];
        if(c == 'R')  d = (d+1) % 4;
        if(c == 'L')  d = (d-1+4) % 4;
    }

    bool isRobotBounded(string s) {
        int rounds = 4;
        while(rounds--){
            for(auto &c: s){
                move(c);
            }
        }

        return x == 0 && y == 0;
    }
};
