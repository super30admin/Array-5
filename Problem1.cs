// Time Complexity : O(n) where n is the length of instructions
// Space Complexity : O(1) space consumed by directions matrix
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*
I represent the four directions as follows: **0 → North, 1 → West, 2 → South, and 3 → East**. The robot starts at position **(0, 0)** facing **North** (direction `0`).

I iterate through each character in the instruction string:

* If the instruction is **'G'**, the robot moves one step forward in its current direction by updating the `x` and `y` coordinates using the corresponding direction vector.
* If the instruction is **'L'**, the robot turns left by updating the direction as `dir = (dir + 3) % 4`.
* If the instruction is **'R'**, the robot turns right by updating the direction as `dir = (dir + 1) % 4`.

After executing the instruction sequence once, the robot is guaranteed to remain within a bounded circle if **either**:

1. It returns to the origin `(0, 0)`, **or**
2. It is not facing North (`dir != 0`).

If the robot is not facing North after one execution, repeating the instructions will eventually cause it to loop back to its starting position, ensuring that its path remains bounded.

*/

public class Solution
{
    public bool IsRobotBounded(string instructions)
    {
        int[][] dirs = new int[][]
        {
            new int[] {0,1},
            new int[] {1,0},
            new int[] {0,-1},
            new int[] {-1,0},
        };

        int dir = 0;

        int[] position = { 0, 0 };

        for (int i = 0; i < instructions.Length; i++)
        {
            if (instructions[i] == 'L')
            {
                dir = (dir + 3) % 4;
            }

            else if (instructions[i] == 'R')
            {
                dir = (dir + 1) % 4;
            }

            else
            {
                position[0] += dirs[dir][0];
                position[1] += dirs[dir][1];
            }
        }

        return (position[0] == 0 && position[1] == 0) || dir != 0;
    }
}