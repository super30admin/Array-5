#Time Complexity:O(n)
#Space Complexity:O(1)
#Approach: Initialize directions array having N,W,S,E directions.Let x and y represent the co-ordinates of the current position. The current
#faced direction is represented by i pointer. For every character in the instructions, change the directions according to L or R using the i 
#pointer. Use the ith direction to move forward and change the x and y co-ordinates. Return the boolean value if current direction is north and 
#co-ordinates are same as origin.
class Solution:
    def isRobotBounded(self, instructions: str) -> bool:
        if not instructions:
            return True
        dirs=[[0,1],[-1,0],[0,-1],[1,0]]
        x=0
        y=0
        i=0
        for k in range(len(instructions)):
            ch=instructions[k]
            if ch=='L':
                i=(i+1)%4
            elif ch=='R':
                i=(i+3)%4
            else:
                x+=dirs[i][0]
                y+=dirs[i][1]
        return i!=0 or (x==0 and y==0)