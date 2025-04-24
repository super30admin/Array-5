class Solution:
    def isRobotBounded(self, instructions: str) -> bool:
        if len(instructions) == 0:
            return True
        dirs = [[0,1] , [-1,0], [0, -1], [1,0]] # NLSR
        x, y = 0,0
        i = 0
        for j in range(0, len(instructions)):
            c = instructions[j]
            if c == 'G':
                x = x + dirs[i][0]
                y = y + dirs[i][1]
            elif c == 'L':
                i = (i+1) % 4
            elif c == 'R':
                i = (i+3) % 4
        return (x == 0 and y == 0) or i != 0
    # TC : O(n)
    # Sc : O(1)

