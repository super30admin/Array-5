#Time complexity : O(n)
#Space complexity: O(1)
#Works on leetcode : yes
#Approach : The robot is facing in +Y (or north) direction. There are only 2 ways when robot in a circle - 1. It's already
#at origin at the final instruction or 2. Robot is any other direction apart from north at final instruction since after multiple
#traversal, robot will be back to origin

class Solution:
    def isRobotBounded(self, instructions: str) -> bool:
        dirc = (0,1)
        x,y = 0,0 
        for instr in instructions:
            if instr=='G':
                x,y  =x+dirc[0], y+dirc[1]
            elif instr=='L':
                dirc = (-dirc[1],dirc[0])
            else:
                dirc = (dirc[1], -dirc[0])
        return (x==0 and y==0) or dirc != (0,1)