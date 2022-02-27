# // Time Complexity : O(n) where n is str length
# // Space Complexity : o(1)
# // Did this code successfully run on Leetcode : Yes

class Solution:
    def isRobotBounded(self, instructions: str) -> bool:
        if instructions is None or len(instructions) == 0:
            return True
        x = 0
        y = 0

        dirs = [[0, 1], [1, 0], [0, -1], [-1, 0]]
        i = 0

        for j in range(0, len(instructions)):
            c = instructions[j]
            if c == "L":
                i = (i + 3) % 4

            elif c == "R":
                i = (i + 1) % 4

            elif c == "G":
                x = x + dirs[i][0]
                y = y + dirs[i][1]

        return (x == 0 and y == 0) or i != 0




