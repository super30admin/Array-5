class Solution:
    def isRobotBounded(self, instructions: str) -> bool:
        dirs=[(1,0), (0,-1), (-1,0), (0,1)]
        face=0
        x=y=0
        for d in instructions:
            if d=='G':
                dx, dy=dirs[face]
                x+=dx
                y+=dy
                
            elif d=='L':
                face=(face+1)%4
            else:
                face=(face-1)%4
        
        if face!=0 or (x==0 and y==0):
            return True
        return False
        