/*
* Approach1: If we are not able to reach the origin after repeating the instruction at max 4 times, then we wont be able to reach the origin at all. 4 times because the shape that needs to be formed to reach the origin is either square or a rectangle and they have 4 sides to explore
- Use dirs array to keep track of the direction at any time. Dirs array is in anticlockwise direction but clockwise also works 
- Use one pointer to keep track of the directions in the dirs array
    - idx -> starts from 0 which is north -> anticlockwise (turn L)
        - N -> W, W -> S, S -> E, E -> N so basically idx should point to the next index, but we dont want to go out of bounds for E so we do %4 for keeping the pointer in the given length 4 array range
        - counter to the L is right so it should idx + 3 %4 or idx - 1 % 4
- So when G comes, we just check the idx pointer in the dirs array and increment x and y (starting coordinates).
- TC: O(4n) -> O(n) -> run instructions atmax 4 times
- SC: O(1) -> dirs array constant space
 */
class Solution {
    public boolean isRobotBounded(String instructions) {
        int x = 0;
        int y = 0;
        int idx = 0; //index for directions array
        int[][] dirs = new int[][] { { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 0 } }; //anticlockwise

        for (int k = 0; k < 4; k++) {
            for (int i = 0; i < instructions.length(); i++) {
                char ch = instructions.charAt(i);
                if(ch == 'G') {
                    x = x + dirs[idx][0];
                    y = y + dirs[idx][1];
                } else if(ch == 'L') {
                    idx = (idx + 1) % 4;
                }
                // ch == R
                else {
                    idx = (idx + 3) % 4;
                }
            }
            if (x == 0 && y == 0)
                return true;
        }
        return false;
    }
}


/*
* Approach2: The basis remains the same as the first approach
- We can get to know if the robot reaches origin or not by executing instruction only once as well
    - ex GLGR -> here the robot is moving away from the origin and the direction of the robot after executing the instruction once is pointing in the north direction
    - so if the robot is pointing to north and it has not reached the origin already, that means it will never reach the origin, it will keep on going away from the origin. 
- TC: O(n) -> n characters in instructions
- SC: O(1) -> dirs array constant space
 */
class Solution {
    public boolean isRobotBounded(String instructions) {
        int x = 0;
        int y = 0;
        int idx = 0; //index for directions array
        int[][] dirs = new int[][] { { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 0 } }; //anticlockwise

        for (int i = 0; i < instructions.length(); i++) {
            char ch = instructions.charAt(i);
            if (ch == 'G') {
                x = x + dirs[idx][0];
                y = y + dirs[idx][1];
            } else if (ch == 'L') {
                idx = (idx + 1) % 4;
            }
            // ch == R
            else {
                idx = (idx + 3) % 4;
            }
        }

        if (x == 0 && y == 0)
            return true;
        if (idx != 0)
            return true;

        return false;
    }
}