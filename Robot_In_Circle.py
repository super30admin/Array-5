"""
(PLEASE CORRECT ME IF MY TIME AND SPACE ARE WRONG)

Time Complexity : O(N) - length of instructions
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
Your code here along with comments explaining your approach:
Here, we can define our directions as a dirs array in an anti clockwise manner. After iterating through all the instructions, if the
robot is stil facing north, it will never be able to come back to origin. Or else, if the robot reached origin , and is facing north,
then its ok.
"""

class Solution(object):
    def isRobotBounded(self, instructions):
        dirs = [(0, 1), (-1,0), (0, -1), (1, 0)]
        x, y = 0, 0
        d = 0
        
        for i in instructions:
            if i == "L":
                d = (d+1) % 4
            elif i == "R":
                d = (d + 3) % 4
            else:
                x += dirs[d][0]
                y += dirs[d][1]
        if d != 0 or ( x == 0 and y == 0):
            return True
        return False 
