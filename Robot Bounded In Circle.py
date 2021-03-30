#time: O(n)
#space: O(1)
class Solution:
    def isRobotBounded(self, instructions: str) -> bool:
        directions = [[0, 1], [1, 0], [0, -1], [-1, 0]] 
        x=0
        y=0
        i=0
        for ins in instructions:
            if ins == "L":
                i = (i + 3) % 4
            elif ins == "R":
                i = (i + 1) % 4
            else:
                x += directions[i][0]
                y += directions[i][1]
        
        
        if (x == 0 and y == 0) or i!=0:
            return True
        else:
            return False