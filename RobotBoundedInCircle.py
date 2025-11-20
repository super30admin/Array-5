# Time is O(n), space is O(1)

# The intuition here is to go through the instructions, after that if the robot comes back to the starting point we can return True.
# Otherwise check if the robot was in any other direction other than the current facing one which is North then also we can return True

class Solution:
    def isRobotBounded(self, instructions: str) -> bool:
        dirs = [(0,1), (-1,0), (0,-1), (1,0)]
        x = 0
        y = 0
        idx = 0
        for j in range(len(instructions)):
            if instructions[j] == "G":
                x += dirs[idx][0]
                y += dirs[idx][1]
            elif instructions[j] == "L":
                idx = (idx + 1) % 4
            else:
                idx = (idx+3) % 4
        if x == 0 and y == 0 or (idx != 0):
                return True
        return False