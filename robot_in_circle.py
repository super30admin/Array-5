"""
TC: O(n)
SP: O(1)
direction represents anti clock wise rotation. move the direction pointers based on L/R instructions. 
"""
class Solution:
    def isRobotBounded(self, instructions: str) -> bool:
        direction = [(0, 1), (-1, 0), (0, -1), (1, 0)]
        d = 0
        loc = [0, 0]
        j = 0
        while j < 4:
            for i in instructions:
                if i == "G":
                    loc[0] += direction[d][0]
                    loc[1] += direction[d][1]
                elif i == "L":
                    d = (d + 1) % 4
                else:
                    d = (d + 3) % 4
            j += 1

        return loc == [0, 0]
