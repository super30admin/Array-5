#Time Complexity : O(n)
#Space Complexity : O(1)

class Solution:
    def isRobotBounded(self, instructions: str) -> bool:
        #        N      E       S      W
        dirs = [[0,1], [1,0], [0,-1], [-1,0]]
        cur = 0
        x, y = 0,0
        for i in instructions:
            if i == 'L':
                cur = (cur+3) %4
            elif i == 'R':
                cur = (cur+1) %4
            else:
                x += dirs[cur][0]
                y += dirs[cur][1]
                
        return cur!=0 or (x==0 and y==0)