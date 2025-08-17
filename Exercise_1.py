# S30 Problem #170 Robot Bounded In Circle
#LeetCode #1041. https://leetcode.com/problems/robot-bounded-in-circle/description/

# Author : Akaash Trivedi
# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode :  Yes #
# Any problem you faced while coding this : No

# brute force solution
# maximum 4 instruction the robot should come back to origin (it can come back in 1 or 2 as well)
# direction array in clockwise or anit clock direction only: to make robot turn
# in anti clockwise dirs: for turning L: (idx +1) % 4 and turing R: idx + 3 % 4

class Solution:
    def isRobotBounded(self, instructions: str) -> bool:
        #       north, west, south, east
        drcn = [(0, 1), (-1, 0), (0, -1), (1, 0)]
        idx = 0  # direction index in direnction arr
        x = 0
        y = 0
        for j in range(4):
            for i in range(len(instructions)):
                c = instructions[i]
                if c == 'G':
                    # go straight in curr direction
                    x += drcn[idx][0]
                    y += drcn[idx][1]
                elif c == 'L':
                    idx = (idx + 1) % 4
                else:  # turning right
                    idx = (idx + 3) % 4
            if x == 0 and y == 0:
                return True

        return False


# after 1 instruction if robot is not facing north or still at origin
# direction array in clockwise or anit clock direction only: to make robot turn
# in anti clockwise dirs: for turning L: (idx +1) % 4 and turing R: idx + 3 % 4

class Solution:
    def isRobotBounded(self, instructions: str) -> bool:
        #       north, west, south, east
        drcn = [(0, 1), (-1, 0), (0, -1), (1, 0)]
        idx = 0  # direction index in direnction arr
        x = 0
        y = 0
        for i in range(len(instructions)):
            c = instructions[i]
            if c == 'G':
                # go straight in curr direction
                x += drcn[idx][0]
                y += drcn[idx][1]
            elif c == 'L':
                idx = (idx + 1) % 4
            else:  # turning right
                idx = (idx + 3) % 4

        # after 1 instruction check if robot is not facing north OR if facing north and at origin
        if idx != 0 or (x == 0 and y == 0):
            return True
        else:
            return False