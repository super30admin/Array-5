class Solution:
    def isRobotBounded(self, instructions: str) -> bool:
        """
            https://leetcode.com/problems/robot-bounded-in-circle/
            Time Complexity - O(n)
            Space Complexity - O(1)
        """
        # directions N E S W
        dirs = [(0, 1), (1, 0), (0, -1), (-1, 0)]
        # initial (x,y) is origin (0,0) and Robot faces North (0)
        x = y = cur_dir = 0
        for j in range(len(instructions)):
            if instructions[j] == 'L':
                cur_dir = (cur_dir + 3) % 4
            elif instructions[j] == 'R':
                cur_dir = (cur_dir + 1) % 4
            else:
                x += dirs[cur_dir][0]
                y += dirs[cur_dir][1]
        # robot reaches origin or the facing directions is not North
        return (x == 0 and y == 0) or cur_dir != 0


if __name__ == '__main__':
    print(Solution().isRobotBounded('GGLLGG'))
    print(Solution().isRobotBounded('GG'))
    print(Solution().isRobotBounded('GL'))
    print(Solution().isRobotBounded("GLRLLGLL"))
