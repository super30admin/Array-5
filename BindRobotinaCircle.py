#Time Complexity : O(N) The loop iterates over each character in the instructions string exactly once.
#Space Complexity : O(1) No additional data structures are used that grow with the input size.
class Solution:
    def isRobotBounded(self, instructions: str) -> bool:
        dirs = [(0, 1), (1, 0), (0, -1), (-1, 0)]
        idx=0
        x=0
        y=0
        for c in instructions:
            #If instruction is Go --> "G" then move it according to dirs list
            if(c=="G"):
                x += dirs[idx][0]
                y += dirs[idx][1]
            #Turn left (counter-clockwise)
            elif(c=="L"):
                idx = (idx+3)%4
            #Turn right (clockwise)
            else:
                idx = (idx+1)%4
        #Robot is bounded if it's back to the origin or not facing north
        if(x==0 and y==0 or idx!=0):
            return True
        return False