class Solution:
    def isRobotBounded(self, instructions: str) -> bool:
        if len(instructions) == 0 or instructions == None:
            return True
                # n        e      s         w
        dirs = [[0, 1], [1, 0], [0, -1], [-1, 0]]
        k = 0
        x, y = 0, 0
        for i in range(len(instructions)):
            char = instructions[i]
            if char == "L":
                k = (k + 3) % 4
            elif char == "R":
                k = (k + 1) % 4
            else:
                x += dirs[k][0]
                y += dirs[k][1]
        
        return k != 0 or (x == 0 and y == 0)
                
                
# Time Complexity: O(n)
# Space Complexity: O(1)