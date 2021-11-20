# // Time Complexity :O(n) 
# // Space Complexity :O(1) 
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no





class Solution:
    def isRobotBounded(self, instructions: str) -> bool:
        x=0
        y=0
        dirs=[[0,1],[-1,0],[0,-1],[1,0]]
        i=0
        for j in range(len(instructions)):
            
            if instructions[j]=='R':
                i=(i+3)%4
            elif instructions[j]=='L':
                i=(i+1)%4
            elif instructions[j]=='G':
                x=x+dirs[i][0]
                y=y+dirs[i][1]
        print(x,y,i)
        if x==0 and y==0 or i is not 0:
            return True
        else:
            return False