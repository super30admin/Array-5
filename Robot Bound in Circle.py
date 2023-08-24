# Time Complexity : O(length of instruction)
# Space Complecity : O(1)
# The code ran on LeetCode
# Eecute the instructions once and check if the robot is back to (0, 0) or its direction has changes. If yes, return True. If no, return False

class Solution:
    def isRobotBounded(self, instructions: str) -> bool:
        dirs = [[0, 1], [1, 0], [0, -1], [-1, 0]]
        idx = 0
        x = 0; y = 0
        for i in instructions:
            if i == 'G':
                x += dirs[idx][0]
                y += dirs[idx][1]
            elif i == 'L':
                idx = (idx + 3) % 4
            else:
                idx = (idx + 1) % 4

        if (x == 0 and y == 0) or (idx != 0):
            return True
        return False