# Approach: After 1 iteration of instructions, if x,y == 0 or tmp != 0 then we can say we will reach origin, and robot is bounded.
# TC : O(n)
# SC : O(1)
# https://leetcode.com/problems/robot-bounded-in-circle/submissions/
class Solution:
    def isRobotBounded(self, inst: str) -> bool:
        #       N.     E.     S.       W.
        d = ((0, 1), (1, 0), (0, -1), (-1, 0))
        x = y = tmp = 0
        
        for i in range(len(inst)):
            if inst[i] == 'L':
                tmp = (tmp + 1) % 4
            elif inst[i] == 'R':
                tmp = (tmp + 3) % 4
            else:
                x += d[tmp][0]
                y += d[tmp][1]
        return (x==0 and y == 0 ) or tmp != 0 