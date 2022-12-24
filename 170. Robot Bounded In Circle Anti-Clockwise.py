class Solution:
    def isRobotBounded(self, instructions: str) -> bool:
        # initially x and y at [0, 0] coordinates
        x = 0
        y = 0

        # initializing directions array in anti-clockwise direction
        dirs = [[0, 1], [-1, 0], [0, -1], [1, 0]]
        # north    west     south    east
        i = 0

        for j in range(len(instructions)):
            char = instructions[j]
            # if direction is Left
            if char == "L":
                i = (i + 1) % 4
            # if direction is Right
            elif char == "R":
                i = (i + 3) % 4
            # if direction is G(i.e going straight)
            # We'll add to x and y the curr x and y of i'th index
            else:
                x += dirs[i][0]
                y += dirs[i][1]

        # if x and y is 0 then it has reached where it started
        # if i is not 0 i.e if it is not pointing towards north means it will reach where it started
        return (x == 0 and y == 0) or i != 0

# Arrays, Maths
# Time Complexity: O(n). Length of string
# Space Complexity: O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No