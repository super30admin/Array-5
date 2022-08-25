""""// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""

class Solution:
    def isRobotBounded(self, instructions: str) -> bool:

        #    N.     E.     S.       W.
        d = [[0, 1], [1, 0], [0, -1], [-1, 0]]
        x = 0
        y = 0
        temp = 0
        for i in range(len(instructions)):
            if instructions[i] == 'L':
                temp = (temp + 1) % 4
            elif instructions[i] == 'R':
                temp = (temp + 3) % 4
            else:
                x += d[temp][0]
                y += d[temp][1]
        return (x == 0 and y == 0) or temp != 0
