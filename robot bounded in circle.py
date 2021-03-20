"""
Time Complexity : O(n) n: instructions array
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Explaination
when we are facing in initial direction that time only we can not come back to same position 
as it will go away from initial point
when we are facing at other directions or at origin, its sure we will be at origin
"""

class Solution:
    def isRobotBounded(self, instructions: str) -> bool:
        directions = [0,1,2,3]
        # '''         N E S W
        d = 0
        x,y = 0,0
        for i in instructions:
            if i == "G":
                if d == 0:
                    y += 1
                elif d == 1:
                    x += 1
                elif d == 2:
                    y -= 1
                else:
                    x -= 1
                
            if i=="R":
                d = (d+1)%4
            elif i == "L":
                d = (d-1)%4
        
        if d != 0 or x ==0 and y == 0:
            return True
        return False
                