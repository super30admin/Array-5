class Solution {
    // TC: O(n)
    //SC: O(1)
    public boolean isRobotBounded(String instructions) {
        int [][] dirs = new int[][] {{0,1},{1,0},{0,-1},{-1,0}};
        int idx = 0;
        int x = 0, y = 0;
        int n = instructions.length();  
            for(int i = 0; i<n; i++){
                char c = instructions.charAt(i);
                if( c == 'L'){
                    idx = (idx + 1)%4;
                }else if(c == 'R'){
                    idx = (idx + 3)%4;
                }else{
                    x += dirs[idx][0];
                    y +=dirs[idx][1];
                }
            }
        
        return (x == 0 && y == 0 || idx != 0);
    }
}
