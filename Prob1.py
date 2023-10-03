class Solution:
    def isRobotBounded(self, instructions: str) -> bool:
        #1. Mimic the movement with dirs array -> TC O(n) and SC O(1)
        dirs=[[0,1],[1,0],[0,-1],[-1,0]] #use the dir array to mimic movement, and also do it in clockwise
                #north,east,south,west respectively

        x=y=0
        idx=0

        for i in instructions:
            if i=='G':
                x+=dirs[idx][0]
                y+=dirs[idx][1]
            elif i=='L':
                idx=(idx+3)%4 #+3 cause L means, turn left ->the array is set up such that left is always 3 indexes away, then mod 4 to make it work
            else:
                idx=(idx+1)%4 #+1 cause R means, turn right ->the array is set up such that right is always 1 indexes away, then mod 4 to make it work
        
        return (x==0 and y==0) or idx!=0 #1. in the end if we return to origin again, then true immedieately, 
        #2. else if we are not at north, then for true we need not to be facing north. 
        #If we are facing north(inital direction) and not at origin, then it's never coming back to origin -> not in a circle. 
        #So, if not at origin we have to in any other direction for it to come back to origin.