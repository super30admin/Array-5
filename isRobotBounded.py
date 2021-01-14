"""
Time complexity O(N)
Space complexity O(1)

"""

class Solution:
    def isRobotBounded(self, instructions: str) -> bool:
        if len(instructions)==0:
            return True
        # [N,E,S,W] 
        dirs = ((0,1), (1,0), (0,-1),(-1,0))
        #Origin 
        x,y = 0,0
        #Start facing North
        i = 0 
        
        for instruction in instructions:
            """
             If the next instruction is "L", robot faces 90 degrees left
             Initial -> +90 degrees left
             North -> West
             East ->  North
             South -> East
             West ->  South
            """
            """
                if next instruction is "R", robot faces 90 degrees right
            Initial -> +90 degrees right
            North -> East
            East -> South
            South -> West
            West -> North
            
              """
            if instruction == 'L':
                i = (i + 3) % 4 # or (i + 1) % 4
            elif instruction == 'R':
                i = (i+ 1) % 4  # or (i + 3) % 4
            # If next instruction is "G" ,Robot walks straight in the direction it is facing 
            else:
                x += dirs[i][0]
                y += dirs[i][1]
        
        # Finally, if robot is back at origin or facing any direction other than North, it will be bound in a circle
        return (x == 0 and y == 0) or i != 0
        