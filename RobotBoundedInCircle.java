class Solution {
    //TC 0(n)
    //SC 0(1)
    public boolean isRobotBounded(String instructions) {
        if(instructions == null || instructions.length() == 0){
            return true;
        }
        int[][] dir = {{0,1} , {1,0}, {0,-1}, {-1,0}}; //North East South West
        //If the robot goes right, then it goes in clockwise direction and if left then anti clockwise direction. So I have declared my dirs array in clockwise direction.
        int i = 0;  //To keep a track of the direction
        int x = 0;  //to maintain x coordinate
        int y = 0;  //to maintain y coordinate
        for(int j = 0; j < instructions.length(); j++){
            char c = instructions.charAt(j);
            if(c == 'G'){
                x+= dir[i][0];  //if go then I move ahead in the direction the robot is pointing at hence increasing my x and y coordinate
                y+= dir[i][1];
            }
            else if(c == 'L'){
                i = (i+3) % 4;  //if left, then I will move anticlockwise and to get the next direction in anti clockwise I do the above
            }
            else{
                i = (i+1) % 4;  //if right, then I move in clockwise direction. Hence to get the next direction, I do the above.
            }
        }
        return i != 0 || (x==0 && y==0);    //if the direction is facing north, then there is no way that robot can come back to origin hence I return false in that case.
    }
}