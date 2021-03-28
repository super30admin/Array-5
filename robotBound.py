class Solution:
    
    """
    Description: On an infinite plane, a robot initially stands at (0, 0) and faces north, with given directions return if robot can be bounded in a circle
    
    Time Complexity: O(n)
    Space Complexity: O(1)
    
    Approach:
    - define directions pointing to North, West, South and East (anti-clockwise)
    - using the directions update the direction based on the command (left, right or unit movement)
    - if x and y are equal to origin or the dir_idx is not poining to north, return True
    """
    
    def isRobotBounded(self, instructions: str) -> bool:
        
        dirs = [(0, 1), (-1, 0), (0, -1), (1, 0)]
        x = 0; y = 0; dir_idx = 0
        
        for command in instructions:
            if command == "L":
                dir_idx = (dir_idx + 1) % 4
            elif command == "R":
                dir_idx = (dir_idx + 3) % 4
            else:
                x += dirs[dir_idx][0]
                y += dirs[dir_idx][1]
            
        if x == 0 and y == 0:
            return True
        
        if dir_idx != 0: return True
        
        return False
