# class Solution:
    # def isRobotBounded(self, instructions: str) -> bool:
    #     # N,W,S,E
    #     dir = [[0,1], [-1,0], [0,-1], [1,0]]
    #     x, y = 0,0
    #     idx = 0
    #     for i in range(4):
    #         for c in instructions:
    #             if c == "G":
    #                 x+=dir[idx][0]
    #                 y+=dir[idx][1]
    #             elif c == "L":
    #                 idx = (idx+1)%4
    #             elif c == "R":
    #                 idx = (idx+3)%4
    #         if x == 0 and y == 0: return True
    #     return False

class Solution:
    def isRobotBounded(self, instructions: str) -> bool:
        # N,W,S,E
        dir = [[0,1], [-1,0], [0,-1], [1,0]]
        x, y = 0,0
        idx = 0
        for c in instructions:
            if c == "G":
                x+=dir[idx][0]
                y+=dir[idx][1]
            elif c == "L":
                idx = (idx+1)%4
            elif c == "R":
                idx = (idx+3)%4
        return (x == 0 and y == 0) or idx!=0
