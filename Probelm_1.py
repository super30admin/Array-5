'''
Time Complexity - O(4n) for Approach 1, O(n) for approach two
Space Complexity - O(1). We are using a directions array of size 4 at all time.

Works on Leetcode.
'''
class Solution:
    def isRobotBounded(self, instructions: str) -> bool:
        x, y = 0, 0
        dirs = [[0,1], [1,0], [0,-1], [-1, 0]]
        idx= 0

        #Approach 1, run instructions 4 times, if we dont reach origin return False
        # for k in range(4):
        #     for inst in instructions:
        #         if inst == "G":
        #             x += dirs[idx][0]
        #             y += dirs[idx][1]
        #         elif inst == "L":
        #             idx = (idx+3)%4
        #         else:
        #             idx = (idx+1) % 4
        #     if x==0 and y==0:
        #         return True
        # return False
        #Approach 2, run instructions only once
        #at end if we are at origin or if we are pointing anywhere other than North, we are returning back to origin which means result will be true
        #else false
        for inst in instructions:
            if inst == "G":
                x += dirs[idx][0]
                y += dirs[idx][1]
            elif inst == "L":
                idx = (idx+3)%4
            else:
                idx = (idx+1) % 4
        if (x==0 and y==0) or idx !=0:
                return True
        return False

        