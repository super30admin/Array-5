class Solution:
    def isRobotBounded(self, instructions: str) -> bool:
        if instructions ==None or len(instructions)==0:
            return True
        dirs=[(0,1),(-1,0),(0,-1),(1,0)]
        x=0
        y=0
        i=0
        for k in range(len(instructions)):
            c=instructions[k]
            if c=='L':
                i=(i+1)%4
            elif c=='R':
                i=(i+3)%4
            else:
                x+=dirs[i][0]
                y+=dirs[i][1]
        #if it comes back to origin or faces all directions except north
        #after first set of intructions
        if (x==0 and y==0)  or i!=0:
            return True
        return False
        
#time Complexity is O(n)
#Space is O(1)
