"""
Simulate the single instruction string once, tracking position (x,y) and facing direction
After one pass, the robot is bounded iff it’s back at origin or it’s not facing North (because repeating will loop or spiral back)
So check: (x, y) == (0, 0) or dir != North
"""
"""
Time Complexity: O(n), one pass over the instruction string
Space Complexity: O(1)
"""


class robotCircle:
    def isRobotBounded(self, instructions: str) -> bool:

        dirs = [(0,1), (1,0), (0,-1), (-1,0)]
        x = y = 0
        d = 0  # 0=N,1=E,2=S,3=W

        for ch in instructions:
            if ch == 'G':
                dx, dy = dirs[d]
                x += dx
                y += dy
            elif ch == 'L':
                d = (d + 3) % 4
            else:  # 'R'
                d = (d + 1) % 4

        return (x == 0 and y == 0) or d != 0
    
if __name__ == "__main__":
    obj = robotCircle()
    print(obj.isRobotBounded("GGLLGG"))   # True (comes back to origin)
    print(obj.isRobotBounded("GG"))       # False (moves straight north)
    print(obj.isRobotBounded("GL"))       # True (turns and loops in a square)
    print(obj.isRobotBounded("GLGLGGLGL"))# True

