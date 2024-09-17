class Solution {
public:
    bool isRobotBounded(string instructions) {
        int x=0,y=0,dir=0;
        
        for (int i=0;i<instructions.length();i++) {
            if (instructions[i]=='L') {
                dir=(dir+1)%4;
            } else if (instructions[i]=='R') {
                dir=(dir+3)%4;
            } else {
                if (dir==0) {
                    y++;
                } else if (dir==1) {
                    x++;
                } else if (dir==2) {
                    y--;
                } else if (dir==3) {
                    x--;
                }
            }
        }
        return (x==0 && y==0 || dir!=0);
    }
};