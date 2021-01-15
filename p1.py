#Time: O(n)
#Space: O(1)
class Solution(object):
    def isRobotBounded(self, instructions):
        """
        :type instructions: str
        :rtype: bool
        """
        
        dirs = [[0,1], [1,0], [0,-1], [-1,0]] 

        i = 0
        x, y = 0,0

        for j in range(len(instructions)):
            temp = instructions[j]

            if temp == 'R':
                i = (i + 1) % 4
            elif temp == 'L':
                i = (i+3) % 4
            else:
                x += dirs[i][0]
                y += dirs[i][1]

        return (x==0 and y==0) or i > 0
