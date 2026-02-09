#  Time Complexity : O(N)   N is the length of the instructions
#  Space Complexity : O(1)  
#  Did this code successfully run on Leetcode : Yes
#  Three line explanation of solution in plain english: The robot simulates one cycle of instructions starting at origin (0,0) facing north, updating its position when moving forward ("G") and rotating its direction index when turning left or right ("L"/"R"). After one cycle, if the robot returns to the origin, it's clearly bounded in a circle. Otherwise, the robot is still bounded if it's facing any direction other than north (idx != 0), because repeating the instructions will eventually form a closed loop—if facing the same direction after one cycle, it would continue infinitely in that direction instead.

class Solution:
    def isRobotBounded(self, instructions: str) -> bool:
        dirs = [[0, 1], [-1, 0], [0, -1], [1, 0]] #N, W, S, E
        x, y = 0, 0
        idx = 0

        for c in instructions:
            if c == "G":
                x += dirs[idx][0]
                y += dirs[idx][1]
            elif c == "L":
                idx = (idx + 1) % 4
            elif c == "R":
                idx = (idx + 3) % 4

        return (x == 0 and y == 0) or idx != 0  