class BindRobotCircle {
    public boolean isRobotBounded(String instructions) {
        int dir[][] = new int[][]{{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
        char [] inst = instructions.toCharArray();
        int index = 0, x=0, y=0;
        for(int i=0; i<4; i++){
           for(char c: inst){
            if(c == 'G'){
                x += dir[index][0];
                y += dir[index][1];
            }
            else if(c == 'L'){
                index = (index + 1) % 4;
             }
             else if(c== 'R'){
                index = (index + 3) % 4;
             }
           } 
           if(x == 0 && y ==0)
                return true;
        }
        return false;
    }
}

/*
 * Time Complexity: O(4*n) ~ O(n)
 * Time Complexity: O(1)
 *
 */