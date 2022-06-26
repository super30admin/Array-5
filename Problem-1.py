class Solution:
    def isRobotBounded(self, instructions: str) -> bool:
        dirs=[[0,1],[1,0],[0,-1],[-1,0]] #NESW
        
        d=0
        x=0
        y=0
        for char in instructions:
            if char=='L':
                d=(d+3)%4
            elif char=='R':
                d=(d+1)%4
            else:
                x+=dirs[d][0]
                y+=dirs[d][1]
                
        return d>0 or x==y==0