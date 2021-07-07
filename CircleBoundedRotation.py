'''
Solution:
1.  Start from origin facing North considering NEWS as 0123 indices.
2.  Whenever you see a Right, change direction to +1 using above indices.
    Whenever you see a Left, change direction to -1 using above indices.
    Whenever you see a Go, move forward in the direction you are in.
3.  After one set of instructions, if the robot is either at (0, 0) or non-North facing => a circle can be formed.

Time Complexity:    O(n)
Space Complexity:   O(1)
--- Passed all testcases successfully on Leetcode.
'''

class Solution:
    def isRobotBounded(self, instructions: str) -> bool:

        #   initializations
        dx = [0, 1, 0, -1]      #   N, E, W, S
        dy = [1, 0, -1, 0]      #   N, E, W, S

        x = 0
        y = 0
        currentDirection = 0

        #   iterate over all iterations
        for instruction in instructions:

            #   case 1 -- Right
            if (instruction == 'R'):
                currentDirection = (currentDirection + 1) % 4

            #   case 2 -- Left
            elif (instruction == 'L'):
                currentDirection = (currentDirection - 1 + 4) % 4

            #   case 3 -- Go
            else:
                x += dx[currentDirection]
                y += dy[currentDirection]

        #   either come back to the origin or the direction is not North
        return (x == 0 and y == 0) or (currentDirection != 0)