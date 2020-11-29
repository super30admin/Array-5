//Time Complexity-O(n)
class Solution {
    public boolean isRobotBounded(String instructions) {
        int dirs[][]={{0,1},{1,0},{0,-1},{-1,0}};
        int i=0;
        int x=0;
        int y=0;
        for(Character c:instructions.toCharArray())
        {
            if(c=='R')
            {
                i=(i+1)%4;
            }
            else if(c=='L')
            {
                i=(i+3)%4;
            }
            else{
                x=x+dirs[i][0];
                y=y+dirs[i][1];
            }
        }
        return (x==0&&y==0)||i>0;
        
    }
}