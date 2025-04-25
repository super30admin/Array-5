#time complexity o(4n) n i shte instruction
class Solution:
    def isRobotBounded(self, instructions: str) -> bool:
        dirs = [(0, 1), (-1, 0), (0, -1), (1, 0)]
        idx = 0 #direction index in dirs array
        x = 0
        y = 0
        for i in range(4):
            for j in range(len(instructions)):
                ch = instructions[j]
                if ch == 'G':
                    x += dirs[idx][0] # 0 +0
                    y += dirs[idx][1] # 0 + 1
                elif ch == 'L':
                    idx = (idx + 1)%4
                else:
                    idx = (idx + 3)%4

            if x == 0 and y == 0:
                return True

        return False