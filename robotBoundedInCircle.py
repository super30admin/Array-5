# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes 
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class Solution:
    def isRobotBounded(self, instructions: str) -> bool:
        if len(instructions) == 0:
            return True
        
        dirs = [[0,1], [-1,0], [0,-1], [1,0]]
        x = y =  0
        i = 0
        
        for j in range(len(instructions)):
            c = instructions[j]
            if c == 'L':
                i = (i+1) % 4
            elif c == 'R':
                i = (i+3) % 4
            else:
                x += dirs[i][0]
                y += dirs[i][1]
        
        return i != 0 or (x == 0 and y == 0)