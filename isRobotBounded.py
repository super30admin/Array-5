class Solution:
    def isRobotBounded(self, instructions: str) -> bool:
        
        
        #directions = NSEW
        
        direction = [[0,1],[1,0],[0,-1],[-1,0]]
        x, y = 0,0
        dir = 0
        for instruction in instructions:
            
            if instruction == "L":
                dir = (dir+3)%4
            elif instruction == "R":
                dir = (dir+1)%4
            else:
                x += direction[dir][0]
                y += direction[dir][1]
            
        return (x==0 and y==0) or dir != 0
Time: O(N)
Space: O(1)
            
                
