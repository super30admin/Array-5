class Solution:
    def isRobotBounded(self, instructions: str) -> bool:
        directions = [[0, 1], [-1, 0], [0, -1],[1, 0]] #N, W, S, E
        currIdx = 0
        x, y = 0, 0
        for i in instructions:
            if i == 'G':
                x += directions[currIdx][0]
                y += directions[currIdx][1]
            elif i == 'L':
                currIdx = (currIdx + 1)%4
            else:
                currIdx = (currIdx + 3)%4

        if (x != 0 or y != 0) and currIdx == 0:
            return False
        return True