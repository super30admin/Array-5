# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach


class Solution:
    def isRobotBounded(self, instructions: str) -> bool:
        if not instructions:
            return None
        # directions should be either clockwise or anticlockwise
        #             North,  West,  South,   East
        directions = [(0, 1), (-1, 0), (0, -1), (1, 0)]
        x = 0
        y = 0
        i = 0  # directions array index
        for k in range(len(instructions)):
            if instructions[k] == "L":
                i = (i + 1) % 4
            elif instructions[k] == "R":
                i = (i + 3) % 4
            else:
                x += directions[i][0]
                y += directions[i][1]

        # if index i is NOT at North or we are at origin
        # if after first set of instructions if index i is at North then it will never come back if not at origin
        return i != 0 or x == 0 and y == 0
