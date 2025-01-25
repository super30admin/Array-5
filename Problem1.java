class Problem1 {
    //TC:O(N)
    //SC:O(1)
    public boolean isRobotBounded(String instructions) {

        int[][] dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        int currDir = 0;
        int  x=0;
        int y =0;
        //for(int i=0;i<4;i++){
        for (char ch : instructions.toCharArray()) {
            if(ch == 'R'){
                currDir = (currDir +1)%4;
            }else if(ch =='L'){
                currDir = (currDir +3)%4;
            }else{
                //for G
                x += dirs[currDir][0];
                y += dirs[currDir][1];
            }
        }


        //}

        //return x ==0 && y==0;
        // after executing it for one time either it should be at origin or the direction should not be facing north ie.. 0
        return currDir !=0 || (x==0 && y ==0);
    }
}