# Bind Robot in a Circle
# // Time Complexity : O(N)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


class Solution:
    def isRobotBounded(self, instructions: str) -> bool:
        directions=[[0,1], [1,0],[0,-1],[-1,0]]
        current=0
        origin=[0,0]
        for i in instructions:
            
            if i=='G':
                origin[0]+=directions[current][0]                   #if the command is G, then you move to the current direction you are in 
                origin[1]+=directions[current][1]
            elif i=='R':
                current = (current+1)%4                             #if its R, then change the current direction to face the right side
            else:
                current = (current+3)%4                             #turn to the left  of the current side

        return current!=0 or origin ==[0,0]                         #after the iteration, if you are at the origin or if you are not facing up, then you will be able to get to the place you started from 
        