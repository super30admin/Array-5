"""
Problem1: Bind Robot in a Circle (https://leetcode.com/problems/robot-bounded-in-circle/)
"""

"""
Problem_1: https://leetcode.com/problems/robot-bounded-in-circle/
"""

class Solution:
    def isRobotBounded(self, instructions: str) -> bool:
        """
        TC: O(N)
        SC: O(1)
        """
        #N=0, E=1, W =2, S = 3
        dirs = [(0,1),(1,0),(0,-1), (-1,0)]
        x ,y = 0,0
        idx = 0
        
        for d in instructions:
            if d == 'G':
                x += dirs[idx][0]
                y += dirs[idx][1]
                
            elif d == 'L':
                idx = (idx+3) % 4
                
            else:
                idx =(idx+1)% 4
                
        return (x==0 and y ==0 ) or idx!=0
        
# Another way of approaching the problem

class Solution:
    def isRobotBounded(self, instructions: str) -> bool:
        """
        TC: O(N)
        SC: O(1)
        """
        # the robot is initially facing north direction {0,1}
        dir_x, dir_y = 0, 1
        # position of the robot
        x , y = 0, 0
        
        for d in instructions:
            if d=="G":
                # if the robot goes straight then we will simply add the direction values in the robot's current position
                x =  x + dir_x
                y =  y + dir_y
            #if the value is left we will only change the direction not the robot's positin. Using algebra  
            elif d=="L":
                dir_x, dir_y = -1*dir_y, dir_x
            else:
                 dir_x, dir_y = dir_y, -1*dir_x
                    
        return  (x==0 and y==0) or (dir_x, dir_y) != ( 0,1)
                
                