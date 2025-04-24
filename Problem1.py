# Problem 1 : Robot Bounded In Circle
# Time Complexity : 
'''
Using the loop from 1 to 4 - O(n) where n is the length of the instructions
'''
# Space Complexity : 
'''
Using the loop from 1 to 4 - O(1)
'''
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
'''
None
'''

# Your code here along with comments explaining your approach

# Using the loop from 1 to 4
class Solution:
    def isRobotBounded(self, instructions: str) -> bool:
        # define directions array in the order north, west, south and east anti-cockwise
        dirs = [[0,1],[-1,0],[0,-1], [1,0]]
        # define idx variable to indicate the direction. Initially set the variable to 0
        idx = 0
        # define x and y co-ordinate and set initially to 0.
        x, y = 0, 0
        # loop from 0 to 4. Since 4 times number of instruction is required to reach again the origin
        for _ in range(4):
            # loop through character of instructions
            for ch in instructions:
                # check if the character is 'G'
                if ch == 'G':
                    # if it is then add the dirs[idx][0] to current x to get new x
                    x += dirs[idx][0]
                    # add the dirs[idx][1] to current y to get new y
                    y += dirs[idx][1]
                # check if the character is 'L'
                elif ch == 'L':
                    # if it is then calculate the idx as (idx+1) % 4
                    idx = (idx + 1) % 4
                else:
                    # else the idx will be (idx+3) % 4
                    idx = (idx + 3) % 4
            # check if value of x and y is 0 then return True
            if x == 0 and y == 0:
                return True
        # return False
        return False

# checking if the last direction is north or not
class Solution:
    def isRobotBounded(self, instructions: str) -> bool:
        # define directions array in the order north, west, south and east anti-cockwise
        dirs = [[0,1],[-1,0],[0,-1], [1,0]]
        # define idx variable to indicate the direction. Initially set the variable to 0
        idx = 0
        # define x and y co-ordinate and set initially to 0.
        x, y = 0, 0

        # loop through character of instructions
        for ch in instructions:
            # check if the character is 'G'
            if ch == 'G':
                # if it is then add the dirs[idx][0] to current x to get new x
                x += dirs[idx][0]
                # add the dirs[idx][1] to current y to get new y
                y += dirs[idx][1]
            # check if the character is 'L'
            elif ch == 'L':
                # if it is then calculate the idx as (idx+1) % 4
                idx = (idx + 1) % 4
            else:
                # else the idx will be (idx+3) % 4
                idx = (idx + 3) % 4
        # check if value of x and y is 0 or the value of idx is not equal to 0 then return True
        if (x == 0 and y == 0) or idx != 0:
            return True
        # return False
        return False
        