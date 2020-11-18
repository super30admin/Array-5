
# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach

# There are four directions where the robot can point towards. We know that initially 
# robot faces north. By observation: if the robot ends up facing any other direction than north, 
# there is a chance of it meeting at the origin after n # of iterations. 
# However, if the robot faces north, it will keep increasing the distance and will move 
# further away and never meet at the origin.

class Solution:
    def isRobotBounded(self, instructions: str) -> bool:
        
        dirs = [[0,1],[1,0],[0,-1],[-1,0]] #Up, Right, Down, Left
        
        i = 0
        x,y =0,0
        
        for j in range(0, len(instructions)):
            ch = instructions[j]
            if ch=='R':
                i = (i+1)%4
            elif ch == 'L':
                i = (i+3)%4
            else: #G
                x += dirs[i][0]
                y += dirs[i][1]
                
        return (x==0 and y==0) or i>0
                
        