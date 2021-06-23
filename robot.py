#To solve this problem we detect the circle by checking the direection array and incrementing as per insttructions
#Time complexity: O(n)
#Space Complexity: O(1)
class Solution:
    def isRobotBounded(self, instructions: str) -> bool:
        if len(instructions) == 0:
            return True
        dirs = [(0,1),(1,0),(0,-1),(-1,0)]
        i = 0
        x = 0
        y = 0
        for k in range(len(instructions)):
            c = instructions[k]
            if c == 'L':
                i = (i+1) % 4
            elif c == 'R':
                i = (i+3) % 4
            else:
                x = x + dirs[i][0]
                y = y + dirs[i][1]
        if (i != 0 or (x == 0 and y == 0)):
            return True
        return False