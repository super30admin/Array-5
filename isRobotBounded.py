#Time Complexity : O(n) where n is the number of instructions
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes

class Solution:
    def isRobotBounded(self, instructions: str) -> bool:
        #North = 0, West = 1, South = 2, East = 3
        directions = [[0, 1], [-1, 0], [0, -1], [1, 0]]

        curr = 0 #Starting from North
        x, y = 0, 0
        for instruction in instructions:
            if instruction == "L": #if we need to turn the robot left
                curr = (curr + 1) % 4
            elif instruction == "R": #if we need to turn the robot right
                curr = (curr + 3) % 4
            else: #if robot needs to just move ahead
                x += directions[curr][0]
                y += directions[curr][1]
        #if robot has reached original position or is not facing North in the end
        return True if (curr != 0 or (x == 0 and y == 0)) else False
