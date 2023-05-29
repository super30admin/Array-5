# Time Complexity : O(N), where N is the length of the instructions string.
# Space Complexity : O(1)
class Solution:
    def isRobotBounded(self, instructions: str) -> bool:
        # Starting position
        x, y = 0, 0
        # Starting direction (North = 0, East = 1, South = 2, West = 3)
        direction = 0
        
        # Directions: North (0), East (1), South (2), West (3)
        # Move in the respective direction
        directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]
        
        for instruction in instructions:
            if instruction == 'G':
                x += directions[direction][0]
                y += directions[direction][1]
            elif instruction == 'L':
                direction = (direction - 1) % 4
            elif instruction == 'R':
                direction = (direction + 1) % 4
        
        # If the robot returns to the starting position
        # or it is facing any direction other than North
        # after one cycle of instructions, it is bounded in a circle
        return (x, y) == (0, 0) or direction != 0