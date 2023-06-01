class Solution:
    def isRobotBounded(self, instructions: str) -> bool:
        # Time O(n)
        # Space O(1)
        dirs = [[0,1], [1,0], [0,-1], [-1,0]]
        idx = 0
        x,y = 0,0
        for i in instructions:
            if i == 'R':
                idx = (idx + 1) % 4
            elif i == 'L':
                idx = (idx + 3) % 4
            else:
                x += dirs[idx][0]
                y += dirs[idx][1]
        return (x==0 and y==0) or idx != 0