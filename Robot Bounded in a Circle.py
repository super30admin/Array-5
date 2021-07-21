# Time:- O(n)
# Space:- O(1)
# Approach:- The key observation is that if after all the instructions if the robot faces north then it will never be bounded by a circle. But if the robot comes back to the origin or the robot is facing a direction other than north then it will always be bounded by a circle.
class Solution:
    def isRobotBounded(self, instructions: str) -> bool:
              # N     E     S       W
        dirs=[[0,1],[1,0],[0,-1],[-1,0]]
        k,l=0,0
        dir_now=0
        for i in instructions:
            if i=='G':
                k,l=k+dirs[dir_now][0],l+dirs[dir_now][1]
            elif i=='L':
                # if the robot is facing north->west,west->south,south->east,east->north
                dir_now=(dir_now+1)%4
            elif i=='R':
                # if the robot is facing north->east,east->south,south->west,west->north
                dir_now=(dir_now+3)%4
        # if somehow we reach the origin or the direction is not north in the end the robot will be always
        # bounded by a circle
        if (k==0 and l==0) or (dir_now>0):
            return True
        return False