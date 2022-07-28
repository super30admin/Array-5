'''
Time Complexity:    O(n)
Space Complexity:   O(1)
Run On LeetCode :   Yes
'''
class Solution:
    def isRobotBounded(self, instructions: str) -> bool:
        
        # define a direction matrix 
        # north = 0, east = 1, south = 2, west = 3 # clockwise manner
        directions = [[0, 1], [1, 0], [0, -1], [-1, 0]]
        
        # initial position is at center and pointing North
        x = 0
        y = 0
        
        currentDir = 0
        
        # iterate the instructions list
        for i in instructions:
            if i == 'L':
                currentDir = (currentDir+3)%4
            elif i == 'R':
                currentDir = (currentDir+1)%4
            else:
                x = x + directions[currentDir][0]
                y = y + directions[currentDir][1]
        
        '''end of for loop'''
        
        # if I am at 0,0 coordinate or not facing North print TRUE
        if x == 0 and y == 0 or currentDir != 0:
            return True
        return False
                