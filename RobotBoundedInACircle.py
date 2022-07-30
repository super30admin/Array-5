#Time complexity; O(n)
#Space complexity: O(1)
class Solution:
    def isRobotBounded(self, instructions: str) -> bool:
        dirs=[[0,1],[-1,0],[0,-1],[1,0]]
        initial_dir=0
        x,y=0,0
        for i in range(len(instructions)):
            if instructions[i]=="L":
                initial_dir=(initial_dir+1)%4
            elif instructions[i]=="R":
                initial_dir=(initial_dir+3)%4
            elif instructions[i]=="G":
                x+=dirs[initial_dir][0]
                y+=dirs[initial_dir][1]
        return (x==0 and y==0) or initial_dir!=0
        