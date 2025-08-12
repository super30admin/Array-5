"""
Time Complexity: O(n)
Space Complexity: O(1)
"""
class Solution:
    def isRobotBounded(self, instructions: str) -> bool:
        dirs = [[0, 1], [-1, 0], [0, -1], [1, 0]]
        x, y, idx = 0, 0, 0

        for c in instructions:
            if c == 'G':
                x += dirs[idx][0]
                y += dirs[idx][1]
            elif c == 'L':
                idx = (idx + 1) % 4
            elif c == 'R':
                idx = (idx + 3) % 4

        return (x == 0 and y == 0) or idx != 0