class Solution:
    # TC : O(n)
    # SC : O(1)
    def isRobotBounded(self, instructions: str) -> bool:
        if instructions is None:
            return True
        dirs = [(0,1),(-1,0),(0,-1),(1,0)] # N W S E
        x,y = 0,0
        i = 0
        for j in range(len(instructions)):
            c = instructions[j]
            if c == "G":
                x += dirs[i][0]
                y += dirs[i][1]
            elif c == "L":
                i = (i+1) % 4
            elif c == "R":
                i = (i+3) % 4
        if (x,y) == (0,0) or i > 0:
            return True
        return False
        