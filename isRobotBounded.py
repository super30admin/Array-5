class Solution:
    def isRobotBounded(self, instructions: str) -> bool:
        directions = [[0,1],[-1,0],[0,-1],[1,0]]
        
        x = y = 0
        
        index = 0
        
        for i in instructions:
            if i =='L':
                index = (index+1)%4
            
            elif i =='R':
                index = (index+3)%4
            
            else:
                x+=directions[index][0]
                y+=directions[index][1]
                
        if index!= 0 or (x==0 and y==0):
            return True
        else:
            return False
            
            #tc o(n)
            #sc o(n)
