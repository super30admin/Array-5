# problem 1 

# https://leetcode.com/problems/robot-bounded-in-circle/description/

class Solution:
    def isRobotBounded(self, instructions: str) -> bool:
        x = 0 
        y = 0
        start_idx = 0
        dir_arr = [[0,1],[1,0],[0,-1],[-1,0]]
        for instruction in instructions:
            if instruction == 'G':
                x = dir_arr[start_idx][0]+x
                y = dir_arr[start_idx][1]+y
            elif instruction == 'L':
                start_idx = (start_idx+3) % 4
            else:
                start_idx = (start_idx+1) % 4 
        if x == 0 and y == 0:
            return True
        if start_idx != 0:
            return True 
        return False