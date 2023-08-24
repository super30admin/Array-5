
'''
Problem: Robot Bounded in a Circle
Time Complexity: O(n), where n is given instructions
Space Complexity: O(1)
Did this code successfully run on Leetcode: Yes
Any problem you faced while coding this: No
Your code here along with comments explaining your approach:
        Take dirs array to be in clockwise direction
        Change direction according to left and right direction
        if at the end of execution of instruction if x==0 and y==0 or direction is not facing north
        then the robot is bounded to circle
'''
class Solution:
    def isRobotBounded(self, instructions: str) -> bool:
        #north, east, south, west
        dirs = [(0,1), (1,0), (0,-1), (-1,0)]
        x = 0
        y = 0

        direction = 0 #north

        for i in instructions:
            if i == 'L':
                direction = (direction+3)%4
            elif i == 'R':
                direction = (direction+1)%4
            else:
                x+=dirs[direction][0]
                y+=dirs[direction][1]
        
        if (x==0 and y==0 ) or direction!=0:
            return True
        else:
            return False

