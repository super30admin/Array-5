# time complexity: O(len(instructions))
# space complexity: O(1)

class Solution:
    def isRobotBounded(self, instructions: str) -> bool:
        # dirs for changing directions
        dirs = [[0, 1], [-1, 0], [0, -1], [1, 0]]
        # x,y maintains the coordinates/location of robots
        x = 0
        y = 0
        # i maintains the index in dirs for current direction
        i = 0

        for s in range(len(instructions)):
            if instructions[s] == "L":
                i = (i + 1) % 4
            elif instructions[s] == "R":
                i = (i + 3) % 4
            if instructions[s] == "G":
                x = x + dirs[i][0]
                y = y + dirs[i][1]

        # if robot is at origin or if robot is not facing north, then it can reach the stating point so return true
        if (x == 0 and y == 0) or i != 0:
            return True