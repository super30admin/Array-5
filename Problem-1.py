# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Explanation:
# Simulate robot movement.
# Track position and direction.
# If after executing instructions:
#   - robot returns to origin OR
#   - robot changes direction
# then path is bounded.

class Solution:
    def isRobotBounded(self, instructions: str) -> bool:
        
        x = y = 0
        dx, dy = 0, 1
        
        for c in instructions:
            if c == 'G':
                x += dx
                y += dy
            elif c == 'L':
                dx, dy = -dy, dx
            else:
                dx, dy = dy, -dx
        
        return (x == 0 and y == 0) or (dx, dy) != (0,1)