#  Time Complexity :O(n)
#  Space Complexity :O(1)
#  Did this code successfully run on Leetcode :yes
#  Any problem you faced while coding this :no

class Solution(object):
    def isRobotBounded(self, instructions):
        """
        :type instructions: str
        :rtype: bool
        """
        # as the robot starts from north direction it will never come to inital point if the final direction is north
        dirs = [[0,1], [1,0], [0,-1], [-1,0]] #U,R,D,L
        
        i = 0
        x, y = 0,0
        
        for j in range(len(instructions)):
            temp = instructions[j]
            
            if temp == 'R':
                i = (i + 1) % 4
            elif temp == 'L':
                i = (i+3) % 4
            else:
                x += dirs[i][0]
                y += dirs[i][1]
        
        return (x==0 and y==0) or i > 0
            