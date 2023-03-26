class Solution {
    public boolean isRobotBounded(String inst) {
        int q = 0;
        int a = 0;
        int b = 0;
        int[][]dir = {{0,1},{1,0},{0,-1},{-1,0}};
        for(int i = 0;i<inst.length();i++){
            char c = inst.charAt(i);
            if(c=='R') q = (q+1)%4;
            else if(c=='L') q = (q+3)%4;
            else {
                a =a+ dir[q][0];
                b =b+ dir[q][1];
            }

        }
    return a==0 && b==0 || q>0;}
}