class Solution:
    def isRobotBounded(self, instructions: str) -> bool:
        ### TIme - O(n)
        ## space-O(1)
        ## des -  if the robot is at (0,0) or facing to the direction other than north by the end of the 1 iteration, then the root is not forming a circle.
        #   N     W     S      E
        dirs = ((0, 1), (-1, 0), (0, -1), (1, 0))
        i = 0
        x = y = 0

        for k in range(len(instructions)):
            if instructions[k] == 'G':
                x += dirs[i][0]
                y += dirs[i][1]
            elif instructions[k] == 'L':
                i = (i + 1) % 4
            elif instructions[k] == 'R':
                i = (i + 3) % 4
        if (i != 0) or (x == 0 and y == 0):
            return True
        return False