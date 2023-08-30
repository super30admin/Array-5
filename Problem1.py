class Solution:
    def isRobotBounded(self, instructions: str) -> bool:
        '''
        Time complexity - O(N), N --> length of the input instructions string. The loop iterates through each instruction once.
        Space complexity - O(1) , to store directions, coordinates, and direction indices.
        '''
        directions = [(0, 1), (1, 0), (0, -1), (-1, 0)
                      ]  # Define possible movement directions: N, E, S, W
        x, y = 0, 0  # Initialize the robot's initial position to (0, 0)
        # Initialize the robot's initial facing direction to N (index 0)
        direction = 0

        for instr in instructions:
            if instr == 'G':
                # Update x coordinate based on the current direction
                x += directions[direction][0]
                # Update y coordinate based on the current direction
                y += directions[direction][1]
            elif instr == 'L':
                # Rotate left: change direction index
                direction = (direction - 1) % 4
            else:
                # Rotate right: change direction index
                direction = (direction + 1) % 4

        # Check if robot is either at (0, 0) or facing a different direction
        # If it's neither, then it's bounded in a circle
        return (x == 0 and y == 0) or direction != 0
