"""

## Problem 1041: Robot Bounded In Circle

## Author: Neha Doiphode
## Date:   11-28-2022

## Description:
        On an infinite plane, a robot initially stands at (0, 0) and faces north. Note that:
            The north direction is the positive direction of the y-axis.
            The south direction is the negative direction of the y-axis.
            The east direction is the positive direction of the x-axis.
            The west direction is the negative direction of the x-axis.

        The robot can receive one of three instructions:
            "G": go straight 1 unit.
            "L": turn 90 degrees to the left (i.e., anti-clockwise direction).
            "R": turn 90 degrees to the right (i.e., clockwise direction).

        The robot performs the instructions given in order, and repeats them forever.
        Return true if and only if there exists a circle in the plane such that the robot never leaves the circle.

 
## Examples:
        Example 1:
            Input: instructions = "GGLLGG"
            Output: true
            Explanation: The robot is initially at (0, 0) facing the north direction.
                        "G": move one step. Position: (0, 1). Direction: North.
                        "G": move one step. Position: (0, 2). Direction: North.
                        "L": turn 90 degrees anti-clockwise. Position: (0, 2). Direction: West.
                        "L": turn 90 degrees anti-clockwise. Position: (0, 2). Direction: South.
                        "G": move one step. Position: (0, 1). Direction: South.
                        "G": move one step. Position: (0, 0). Direction: South.
                        Repeating the instructions, the robot goes into the cycle: (0, 0) --> (0, 1) --> (0, 2) --> (0, 1) --> (0, 0).
                        Based on that, we return true.

        Example 2:
            Input: instructions = "GG"
            Output: false
            Explanation: The robot is initially at (0, 0) facing the north direction.
                        "G": move one step. Position: (0, 1). Direction: North.
                        "G": move one step. Position: (0, 2). Direction: North.
                        Repeating the instructions, keeps advancing in the north direction and does not go into cycles.
                        Based on that, we return false.

        Example 3:
            Input: instructions = "GL"
            Output: true
            Explanation: The robot is initially at (0, 0) facing the north direction.
                        "G": move one step. Position: (0, 1). Direction: North.
                        "L": turn 90 degrees anti-clockwise. Position: (0, 1). Direction: West.
                        "G": move one step. Position: (-1, 1). Direction: West.
                        "L": turn 90 degrees anti-clockwise. Position: (-1, 1). Direction: South.
                        "G": move one step. Position: (-1, 0). Direction: South.
                        "L": turn 90 degrees anti-clockwise. Position: (-1, 0). Direction: East.
                        "G": move one step. Position: (0, 0). Direction: East.
                        "L": turn 90 degrees anti-clockwise. Position: (0, 0). Direction: North.
                        Repeating the instructions, the robot goes into the cycle: (0, 0) --> (0, 1) --> (-1, 1) --> (-1, 0) --> (0, 0).
                        Based on that, we return true.

 ## Constraints:
    1 <= instructions.length <= 100
    instructions[i] is 'G', 'L' or, 'R'.

## Time complexity: O(n), where n is the length of instructions array as we go thru each instruction only once.

## Space complexity: O(1), even though we use auxiliary directions array, space required for it is constant.

"""

from operator import add

def get_input():
    print(f"Enter the instructions for the robot(Combination string of letters L/G/R): ", end = "")
    instructions = input()
    return instructions

class Solution:
    def __init__(self):
        # Arrange directions in either clock-wise directions or anti-clockwise directions
        # Clock-wise: North, East, South, West
        self._directions = [[0,1], [1,0], [0,-1], [-1,0]]
        self._initial = [0,0]

    def isRobotBounded(self, instructions: str) -> bool:
        if len(instructions) == 0:
            return True

        # Left means you are going to move anti-clockwise from wherever you are
        # Right means you are going to move clock-wise from whereever you are
        path = self._initial
        current = 0
        for instruction in instructions:
            if instruction == "G":
                path = list(map(add, path, self._directions[current]))

            elif instruction == "L":
                current = (current - 1) % 4
                #  current = (current + 3) % 4 because left is anti-clockwise
                #  which is west which is at the 3rd index of directions array
                #  in python negative indexing also works so we are using current - 1

            elif instruction == "R":
                current = (current + 1) % 4

        # Check if you either return to the initial point OR
        # check if you are NOT facing north
        # if the robot doesn't face north at the end of the first cycle,
        # then after 4 cycles, the robot is back to the initial coordinates and faces north.
        # principles of limit cycle trajectory
        return (path == self._initial or current != 0)


# Driver code
solution = Solution()
instructions = get_input()
print(f"Input: Instructions: {instructions}")
print(f"Output: Is path of the robot bounded by a circle?: {solution.isRobotBounded(instructions)}")