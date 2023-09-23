# Time Complexity: O(n)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

class Solution(object):
    def isRobotBounded(self, instructions):
        """
        :type instructions: str
        :rtype: bool
        """
        x = 0
        y = 0
        d = 0
        directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]
        for instruction in instructions:
            if instruction == 'G':
                x += directions[d][0]
                y += directions[d][1]
            elif instruction == 'L':
                d = ((d + 3) % 4)
            else:
                d = ((d + 1) % 4)
        return (x, y) == (0, 0) or (d > 0)