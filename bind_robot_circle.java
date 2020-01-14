//TC: O(n)
// SC: O(1)
//Leetcode test cases passed: 78/110

class Solution {
    public boolean isRobotBounded(String ins) {
        int[][] pos = new int[ins.length()][2];
        int dir=0;
        //pos[0][0]=0;
        int i=0,j=0;
        int orig_i = i, orig_j = j;
        for(int k=0;k<ins.length();k++){
            Character c = ins.charAt(k);
            i = pos[k][0];
            j = pos[k][1];
            dir = currPos(i,j,i-1,j-1,pos);
            if(c=='G') pos[k]=funcG(i,j,dir,pos);
            if(c=='L') pos[k]=funcL(i,j,dir,pos);
            if(c=='R') pos[k]=funcR(i,j,dir,pos);
            //System.out.println(pos[k][0]+" "+pos[k][1]);
        }
        
        return (orig_i==i&&orig_j==j);
    }
    
    private int currPos(int i, int j, int prev_i, int prev_j, int[][] pos){
        if(i-prev_i>0&&j-prev_j==0) return 0; //N
        else if(i-prev_i==0&&j-prev_j>0) return 1; //E
        else if(i-prev_i==0&&j-prev_j<0) return 2; //W
        else if(i-prev_i<0&&j-prev_j==0) return 3; //S
        return -1;
    }
    
    private int[] funcG(int i, int j, int dir, int[][] pos){
        switch(dir){
            case '0':j+=1; break;
            case '1':i+=1; break;
            case '2':j-=1; break;
            case '3':i-=1; break;
        }
        return new int[] {i,j};
    }
    
    private int[] funcL(int i, int j, int dir, int[][] pos){
        switch(dir){
            case '0':i-=1; break;
            case '1':j+=1; break;
            case '2':j-=1; break;
            case '3':i+=1; break;
        }
        return new int[] {i,j};
    }
    
    private int[] funcR(int i, int j, int dir, int[][] pos){
        switch(dir){
            case '0':i+=1; break;
            case '1':j-=1; break;
            case '2':j+=1; break;
            case '3':i-=1; break;
        }
        return new int[] {i,j};
    }
    
}
