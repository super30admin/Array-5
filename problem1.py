#time O(N)
#space O(1)
class Solution:
    def isRobotBounded(self, instructions: str) -> bool:
        i=0
        dirs = [[0, 1], [1, 0], [0, -1], [-1, 0]] #n,e,s,w
        step=[0,0]
        for k in instructions:
            if k=="G":
                step[0]+=dirs[i][0]
                step[1]+=dirs[i][1]
            if k=="L":
                i=(i+3)%4
            if k=="R":
                i=(i+1)%4
        if (step[0]!=0 or step[1]!=0) and i==0 :
            return False
        return True
  
                
        