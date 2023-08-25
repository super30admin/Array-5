# Time Complexity : O(n)
# Space Complexity :O(1)
# Passed on Leetcode: yes

class Solution:
    def isRobotBounded(self, instructions: str) -> bool:

        dirs = [[0,1],[1,0],[0,-1], [-1,0]] #clockwise N,E,S,W
        idx = 0
        x, y = 0, 0
        for i in instructions:
            if i == 'R':
                idx = (idx+1)%4
            
            elif i == 'L':
                idx = (idx+3)%4
            
            else:
                x = dirs[idx][0] + x
                y = dirs[idx][1] + y
        if x == 0 and y == 0:
            return True
        if dirs[idx][1] != 1:
            return True
        return False