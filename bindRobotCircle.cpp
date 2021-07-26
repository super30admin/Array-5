//Time: O(n) where n is the size of the instructions
//Space: O(1) no extra space
typedef pair<int,int> POS;
class Solution {
    vector<POS> dirToMove = {{0,1},{-1,0},{0,-1},{1,0}};
public:
    bool isRobotBounded(string instructions) {
        POS curr,startPos;
        startPos = {0,0};
        curr = startPos;
        int startDirection = 0;
        int direction = startDirection;
        char ins;
        for(int i = 0;i<instructions.length();i++){
            ins = instructions[i];
            if(ins == 'L')
                direction = (direction+1)%4;
            else if(ins == 'R')
                direction = (direction+3)%4;
            else{
                curr.first = curr.first+dirToMove[direction].first;
                curr.second = curr.second+dirToMove[direction].second;
                cout<<curr.first<<":"<<curr.second<<endl;
            }
        }
        //cout<<curr.first<<":"<<curr.second<<endl;
        return ((curr == startPos) || (direction!=startDirection));
    }
};