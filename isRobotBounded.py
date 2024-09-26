#TC:O(n)
#SC:O(1)
#Ran successfully on Leetcode:Yes
#Approach: Basically we use a directions array, for North, east,west and South. 
# #if (dir == 'R')
#                 i = (i + 1) % 4; 
#          else if (dir == 'L')
#                 i = (i + 3) % 4;
# 		 else 
# 				// go in i direction
#The above logic is used to ensure we are taking right directions. 
#True condition is if we stop at (0,0) at the end or there is a possibility to stop there since its a loop.
# It is possible to end in (0,0) if we stop at any direction except the starting one i.e N or (0,1)
# which gives us return i!=0 or( x==0 and y==0)

class Solution:
    def isRobotBounded(self, instructions: str) -> bool:
        if not instructions or len(instructions)==0: return False
        dirs=[[0,1],[-1,0],[0,-1],[1,0]]
        x=0
        y=0
        i=0
        for j in range(len(instructions)):
            if instructions[j]=="L":
                i=(i+1)%4
            elif instructions[j]=="R":
                i=(i+3)%4
            else:
                x+=dirs[i][0]
                y+=dirs[i][1]
        return i!=0 or( x==0 and y==0)
    
