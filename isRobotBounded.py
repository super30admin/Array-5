# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
class Solution:
    def isRobotBounded(self, instructions: str) -> bool:
        # Index   = North=0, East=1, South=2, West=3
        direction = [[0, 1], [1, 0], [0, -1], [-1, 0]]

        x, y = 0, 0
        initDir = 0

        for inst in instructions:
            # Turn Left
            if inst == "L":
                initDir = (initDir + 3) % 4
                print("Instruction: ", inst, " : Dir: ", initDir)
            # Turn Right
            elif inst == "R":
                initDir = (initDir + 1) % 4
                print("Instruction: ", inst, " : Dir: ", initDir)
            # Keep North
            else:
                x += direction[initDir][0]
                y += direction[initDir][1]
                print(" coor: ", x, " , ", y)

        return (x==0 and y==0) or initDir!=0
