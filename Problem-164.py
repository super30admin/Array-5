'''

1041. Robot Bounded In Circle
time complexity - O(N)
space complexity - o(1)

Approach -  we need to maintain the direction array
            1) if it is left then i pointer is (i+3)%4 
            2) if it is right then i pointer is (i+1)%4
            3) in the the i pointer should not point to Nrth or 0 and x and y should reach to the starting point
                 

'''
class Solution:
    def isRobotBounded(self, instructions: str) -> bool:
        dir=[[0,1],[1,0],[0,-1],[-1,0]] # N, E,S,W order should be maintained
        x=1
        y=1
        i=0
        for j in range(len(instructions)):
            if instructions[j]=="L":
                i=(i+3)%4
            elif instructions[j]=="R":
                i=(i+1)%4
            else:
                x+=dir[i][0]
                y+=dir[i][1]
        return x==1 and  y==1 or i>0 # (i!=N)
        
        