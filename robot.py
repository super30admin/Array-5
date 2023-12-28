# Time: O(n)
# Space: O(1)
# Did it run on Leetcode: yes

class Solution(object):
    def isRobotBounded(self, instructions):
        """
        :type instructions: str
        :rtype: bool
        """
        dirs=[[0,1],[1,0],[0,-1],[-1,0]]
        idx=0
        x,y=0,0
        for i in range(4):
            for j in range(len(instructions)):
                c=instructions[j]
                if(c=='G'):
                    x+=dirs[idx][0]
                    y+=dirs[idx][1]
                elif(c=='L'):
                    idx=(idx+1)%4
                else:
                    idx=(idx+3)%4
            if(x==0 and y==0):
                return True
        return False
