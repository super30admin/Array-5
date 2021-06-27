class Solution:
    def isRobotBounded(self, instructions: str) -> bool:
        
        
        dirs = [(1,0),(0,1),(-1,0),(0,-1)]
        #dirs = [[0, 1], [1, 0], [0, -1], [-1, 0]]
        x, y,idx = 0,0, 0
        for i in instructions:
            
            if i == 'L':
                idx = (3 + idx) % 4
            elif i == "R":
                idx = (1 + idx) % 4
            
            else:
                x += dirs[idx][0]
                y += dirs[idx][1]
                            
        return (x == 0 and y == 0) or idx != 0
                
