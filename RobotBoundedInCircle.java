
//Time Complexity : O(n); where n is length of input string.
//Space Complexity : O(1)

public class RobotBoundedInCircle { 
	/**Approach: One Pass | Time O(n) | Space O(1)**/	
	public boolean isRobotBounded(String instructions) {
        //Clockwise      N     E      S      W 
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        int i = 0; // Pointer for dirs array
        int x=0; int y=0; //initial coordinates for robot
        
        for(char c: instructions.toCharArray()){
            if(c == 'G'){
                x+= dirs[i][0];
                y+= dirs[i][1];
            }else if (c == 'R'){
                i = (i+1) % 4;
            }else if (c == 'L'){
                i = (i+3) % 4;
            }
        }
        //Robot can come back to origin if :
        //Robot is at origin already OR,
        //After first set of rotation, Robot direction<>N        
        return i != 0 || (x==0 && y==0);
    }
    
	// Driver code to test above
	public static void main (String[] args) {	
		RobotBoundedInCircle ob  = new RobotBoundedInCircle();			
		String instructions = "GGLLGG";
		System.out.println("Is there a circle in the plane for robot to move? "+ob.isRobotBounded(instructions));
	}
}
