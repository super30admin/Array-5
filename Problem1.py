"""
time : o(n), length of input  
space : constant
"""

class Solution(object):
    def isRobotBounded(self, instructions):
        """
        :type instructions: str
        :rtype: bool
        """
        i = 0
        start = [0,0]
        dirs = [[-1,0],[0,-1],[1,0],[0,1]] #north, left, down, right
        
        for ins in instructions:
            if ins == 'L':
                i = (i + 1) % 4
            
            elif ins == 'R':
                i = (i + 3) % 4
                
            else:
                start[0] += dirs[i][0]
                start[1] += dirs[i][1]
        
        
        if start == [0,0] or i > 0:
            return True
        
        return False