#Time : O(N)
#Space: O(1)
#Works fine on leetcode

class Solution:
    def isRobotBounded(self, instructions: str) -> bool:
        
        if len(instructions) == 0:
            return True
        
        dirs = [[0,1],[1,0],[0,-1],[-1,0]] # creating a direction array in NESW order
        
        x= 0
        y = 0
        
        i = 0
        
        for j in range(len(instructions)):
            if(instructions[j] == 'R'): # Changing direction if instruction is right
                i= (i+1)%4
            elif(instructions[j] == 'L'): # Changing direction if instruction is right
                i = (i+3)%4
            else:
                # moving in a given direction
                x+=dirs[i][0]
                y+= dirs[i][1]
        if(x==0 and y==0 or i!=0): # if the rbot comes to the origin or is not facing north after first set of istructions
            return True
                