'''
Accepted on leetcode(1041)
time - O(N)
space - O(1)
Approach:
1. Create a directions array(N,E,S,W)
2. initialize positions(x,y) and 'i' is a direction pointer.
3. Iterate through the instructions and add 3 if we encounter L and add 1 if we encounter R else just add dirs to x, y according to 'i' at that time.
4. return true if x and y are 0 or direction(i) is not North.
'''


class Solution:
    def isRobotBounded(self, instructions: str) -> bool:
        dirs = [[0, 1], [1, 0], [0, -1], [-1, 0]]  # N, E, S, W

        # initial positions
        x = 0
        y = 0

        i = 0

        for j in range(len(instructions)):
            ch = instructions[j]

            if ch == 'L':
                i = (i + 3) % 4
            elif ch == 'R':
                i = (i + 1) % 4

            else:
                x += dirs[i][0]
                y += dirs[i][1]

        return (x == 0 and y == 0) or i > 0