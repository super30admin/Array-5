# Time Complexity : O(N) where N number of instructions
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def isRobotBounded(self, instructions: str) -> bool:
        if len(instructions) == 0:
            return True
        #         N      E        S         W  
        dirs = [[0,1], [1, 0], [0, -1], [-1, 0]]
        
        x, y = 0, 0
        i = 0
        
        for c in instructions:
            if c == 'L':
                i = (i + 3) % 4
            elif c == 'R':
                i = (i + 1) % 4
            else:
                x = x + dirs[i][0]
                y = y + dirs[i][1]
                
        
        return (x == 0 and y == 0) or i != 0