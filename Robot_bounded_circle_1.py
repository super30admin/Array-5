# Time complexity : O(n)
# Space complexity : O(1)
# Leetcode : Solved and submitted

class Solution:
    def isRobotBounded(self, instructions: str) -> bool:
        n = len(instructions)
        
        # build dirs array in a clockwise manner which can also be used to change the values for movement
        # N, E, S, W (clockwise direction)
        dirs = [[0,1],[1,0],[0,-1],[-1,0]]
        
        # starting from origin and the direction index starting is always 0 (north)
        x = 0; y = 0; idx = 0;
        
        # traverse over the string
        for i in range(n):
            ch = instructions[i]
            
            # if the encountered command is G, which means to move in the current direction by 1
            if ch == 'G':
                x += dirs[idx][0]
                y += dirs[idx][1]
            
            # if command is L, then we move the idx pointer to left in the dirs array using the mod
            elif ch == 'L':
                idx = (idx+3)%4
            # if command is R, then we move the idx pointer to right in the dirs array using the mod
            else:
                idx = (idx+1)%4
        
        # at the end, we can check if we reached origin or if the robot is facing north then also return false as we started from North
        # if after one iteration we face north, then never we can return to origin
        return x==0 and y==0 or idx != 0
