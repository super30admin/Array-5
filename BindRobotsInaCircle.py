# Time Complexity : O(mn)
# Space Complexity :O(m+n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution:
    def isRobotBounded(self, instructions):
        if len(instructions) == 0:
            return True 
        #        N.      W.     S.     E.
        dirs = [[0,1], [-1,0],[0,-1],[1,0]]
        i = 0 
        prj = [0,0]
        for k in range(len(instructions)):
            if instructions[k] == 'L':
                i = (i + 1) % 4

            elif instructions[k] == 'R':
                i = (i+3) % 4 
            
            else: # going
                prj[0] += dirs[i][0]
                prj[1] += dirs[i][1]
        
        if (i%4) != 0 or prj == [0,0]:
            return True 
        return False 
                 
            
if __name__ == "__main__":
    s = Solution()
    directions = "GGLLGG"
    res = s.isRobotBounded(directions)
    assert res == True
        