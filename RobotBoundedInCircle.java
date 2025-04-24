class RobotBoundedInCircle {
    public boolean isRobotBounded(String instructions) {
        int dir[][] = new int[][]{{0,1},{-1,0},{0,-1},{1,0}};
        int idx=0;
        int x=0;
        int y=0;
            for(int j=0;j<instructions.length();j++)
            {
                char ch = instructions.charAt(j);
                if(ch =='G')
                {
                    x+=dir[idx][0]; //0+0
                    y+=dir[idx][1]; //0+1

                }
                else if(ch =='L')
                {
                    idx = (idx+3)%4;
                }
                else if(ch =='R'){
                    idx = (idx+1)%4;
                }
            }
            return (x==0 && y==0) || idx!=0;
    }
}

//tc: O(n)
//sc:O(1)