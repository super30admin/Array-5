 /*
 Time Complexity: O(N)
 Space Complexity: O(1)
 */
 public boolean isRobotBounded(String instructions) {
        int[] endPosition = {0,0};
        int endDirection = move(instructions, endPosition);
        return endDirection!=0 || (endPosition[0]==0 && endPosition[1]==0);
    }
    
    int move(String instructions, int[] endPosition){
        int endDirection = 0;
        
        for(char ch : instructions.toCharArray()){
            if(ch=='R'){
                endDirection = (endDirection+1) % 4;
            } else if(ch=='L'){
                endDirection = (endDirection==0? 3 : endDirection-1) % 4;
            } else {
                if(endDirection==0){
                    endPosition[0]++;
                } else if(endDirection==2){
                    endPosition[0]--;
                } else if(endDirection==1){
                    endPosition[1]++;
                } else if(endDirection==3){
                    endPosition[1]--;
                }
            }
        }
        return endDirection;
    }