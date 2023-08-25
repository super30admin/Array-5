class Problem1041 {
//TC=O(n)
//SC = O(1)  
   // N, E, S, W
    int[][] dir ={{0,1},{1,0},{0,-1},{-1,0}};
    public boolean isRobotBounded(String instructions) {
        int x = 0;
        int y = 0;
        int i = 0;
        int count=0;
        for(char ch : instructions.toCharArray()){
            if(ch =='L'){
                i = (i+3)%4;
                count++;
            }
            else if(ch=='R'){
                i = (i +1)%4;
                count--;
            }
            else{
                x = x + dir[i][0];
                y = y + dir[i][1];
            }
        }
        
      //if robot return to origin it is going to be in circle
        //if it is directing to any direction other than starting direction, 
        //it will be in circle.
        return ((x==0 && y==0) || count%4 !=0);
    }
  public static void main(String[] args) {
        Problem1041 problem=new Problem1041();
        System.out.println(problem.isRobotBounded("GGLLGG"));
        System.out.println(problem.isRobotBounded("GLGLGGLGL"));
        System.out.println(problem.isRobotBounded("GGLLGGRR"));
    }
}
