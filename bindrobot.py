# Time complexity - O(n) length of instructions
# Space complexity - O(1)
# Did this solution run on leetcode? - yes
class Solution:
    def isRobotBounded(self, instructions: str) -> bool:
        # edge case
        if not instructions:
            return True
        
        # directions array (anti-clockwise)
        directions = [(0, 1), (-1, 0), (0, -1), (1, 0)]
        
        n = len(instructions)       # length of instructions array.
        curr = (0, 0)               # starting position
        
        i=0             # to traverse the instructions
        j=0             # to traverse the directions array
        while i<n:
            currdir = instructions[i]
            if currdir == "L":      # turn 90 degrees to the left.
                j = (j+1)%4
            elif currdir == "R":      # turn 90 degrees to the right.
                j = (j+3)%4         # to find the clockwise position
            else:
                move = directions[j]    # fetch the next move.
                curr = (curr[0]+move[0], curr[1]+move[1])
            i+=1
        
        return j!=0 or curr==(0, 0) 
    
    
# Time complexity - O(n) length of instructions
# Space complexity - O(1)
# Did this solution run on leetcode? - yes
# by using a clockwise directions array.
class Solution:
    def isRobotBounded(self, instructions: str) -> bool:
        # edge case
        if not instructions:
            return True
        
        # directions array (clockwise)
        directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]
        
        n = len(instructions)       # length of instructions array.
        curr = (0, 0)               # starting position
        
        i=0             # to traverse the instructions
        j=0             # to traverse the directions array
        while i<n:
            currdir = instructions[i]
            if currdir == "L":      # turn 90 degrees to the left.
                j = (j+3)%4
            elif currdir == "R":      # turn 90 degrees to the right.
                j = (j+1)%4         # to find the clockwise position
            else:
                move = directions[j]    # fetch the next move.
                curr = (curr[0]+move[0], curr[1]+move[1])
            i+=1
        
        return j!=0 or curr==(0, 0) 
    