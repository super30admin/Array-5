// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public boolean isRobotBounded(String instructions) {
        
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        int x = 0, y = 0;
        int currentDirection = 0;

        for(char i : instructions.toCharArray()) {
        	if(i == 'R') {
        		currentDirection = (currentDirection + 1) % 4;
        	} else if(i == 'L') {
        		currentDirection = (currentDirection + 3) % 4;
        	} else {
        		x += dx[currentDirection];
        		y += dy[currentDirection];
        	}
        }

        return (x == 0 && y == 0) || currentDirection != 0;
    }
}