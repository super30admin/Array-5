# Time: O(len(instructions))
# Space: O(1)
class Solution(object):
    def isRobotBounded(self, instructions):
        """
        :type instructions: str
        :rtype: bool
        """
        l = {'N': 'W', 'S': 'E', 'E':'N', 'W': 'S'}
        r = {'N': 'E', 'S': 'W', 'E':'S', 'W': 'N'}
        dirs = {'N': [0, 1], 'S': [0, -1], 'E': [1, 0], 'W': [-1, 0]}
        init = [0,0]
        curr_dir = 'N'
        for i in instructions:
            if i == 'G':
                init[0] += dirs[curr_dir][0]
                init[1] += dirs[curr_dir][1]
            else:
                if i == 'L':
                    curr_dir = l[curr_dir]
                else:
                    curr_dir = r[curr_dir]
        if init[0] == 0 and init[1] == 0:
            return True
        if curr_dir != 'N':
            return True
        return False
        
