// Problem Type: Array - 5
// LeetCode - 1041
// https://leetcode.com/problems/robot-bounded-in-circle/

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Unable to approach the problem by breaking down into chunks, especially check if cycle is formed or not.



// Your code here along with comments explaining your approach
/**
 * Algo:
 * 
 * TO DO 1: Approach 1
 * a. Maintain the change in co-ordinate value due to change in the direction, i.e., delta.
 * b. Given only 2 change in directions, i.e., L and R => Generalize formula to fetch delta.
 * c. Start direction = N
 * d. All Possible directions due to L or R = N, W, S, E
 * e. delta: 
 *         N        W       S           E
 *       (0,1)     (-1,0)    (0,-1)      (1,0)
 * f. Pattern Applied: Write delta[] in either anti-clockwise or clockwise direction in order to generaize the new delta due to L or R
 * g. for L:
 *      N -> W
 *      W -> S
 *      S -> E
 *      E -> N
 * 
 *      (current_index + 1 ) % 4
 * h. for R: 
 *      N -> E
 *      E -> S
 *      S -> W
 *      W -> N
 * 
 *      (current_index + 3 ) % 4
 * 
 * TO DO 2: Approach 2
 * How many finite times do we run the instruction to check if it forms a cycle?
 * 
 * a. Forms cycle == reaches the start (0, 0)
 * b. Case 1: Worst Case
 *      GL = 4 times
 *      GR = 4 times
 *      
 *      Run the instructions 4 times
 * c. Case 2: After each set of instructions, check if reached start
 * d. Case 3: Run the instructions once, if the robot goes farther away from the start, it will continue moving farther away after each set of instructions.
 *      So, initially facing N, after running the instructions, it still faces N....it means it will never reach the Source but it will repeat the same path as from Source till current co-ordinate.
 */
/**
 * TC: If # of tax brackets are considered to be constant, then O(1)
 * else, O(n)
 */
/*
 * SC: O(1)
 */

public class RobotBoundedInCircle {

    /**
     * Approach 1
     */
    public boolean isRobotBounded_1(String instructions) {
        int[][] dirs = {{0,1},{-1,0},{0,-1},{1,0}};
        int curr = 0;
        int x = 0;
        int y = 0;
        for(char ch:instructions.toCharArray()) {
            if(ch == 'L') {
                curr = (curr + 1) % 4;
            } else if(ch == 'R') {
                curr = (curr + 3) % 4;
            } else {
                x += dirs[curr][0];
                y += dirs[curr][1];
            }
        }
        return (x == 0 && y == 0) || curr != 0;
    }

    /**
     * Approach 2
     */
    public boolean isRobotBounded_2(String instructions) {
        int[][] dirs = {{0,1},{-1,0},{0,-1},{1,0}};
        int curr = 0;
        int x = 0;
        int y = 0;

        for(int i = 0;i<4;i++) {
            System.out.println("Run " +i);
            for(char ch:instructions.toCharArray()) {
                if(ch == 'L') {
                    curr = (curr + 1) % 4;
                } else if(ch == 'R') {
                    curr = (curr + 3) % 4;
                } else {
                    x += dirs[curr][0];
                    y += dirs[curr][1];
                }
                
                System.out.println(x + "," +y);
            }
            System.out.println();
            if(x == 0&& y==0) {
                return true;
            }
        }
        return false;
    }
}