class Solution:
    def isRobotBounded(self, instructions: str) -> bool:
        ## T.C = O(n)
        ## S.C = O(1)

        dirs = [(0, 1), (1, 0), (0, -1), (-1, 0)]
        i = 0
        x, y = 0, 0

        for j in instructions:
            if j == 'G':
                x += dirs[i][0]
                y += dirs[i][1]
            elif j == 'R':
                i = i + 1
                i = i % 4            
            elif j == 'L':
                i = i + 3
                i = i % 4
        
        return (x == 0 and y == 0) or i != 0