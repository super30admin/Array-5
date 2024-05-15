#TC: O(n)
#SC: O(1)
class Solution:
    def isRobotBounded(self, instructions: str) -> bool:
        direction="N"
        x=0
        y=0
        x,y,direction=self.helper(x,y,direction,instructions)
        if x==0 and y==0:
            return True
        else:
            while(direction!="N"):
                x,y,direction=self.helper(x,y,direction,instructions)
            if x==0 and y==0:
                return True
            else:
                return False
        
    def helper(self, x, y, direction,instructions):
        direction_Hash={"W":(-1,0), "N":(0,1),"E":(1,0),"S":(0,-1)}
        left_Hash={"N":"W","W":"S","S":"E","E":"N"}
        right_Hash={"N":"E","E":"S","S":"W","W":"N"}
        
        for i in instructions:
            if i=="G":
                x=x+direction_Hash[direction][0]
                y=y+direction_Hash[direction][1]
            elif i=="L":
                direction=left_Hash[direction]
            else:
                direction=right_Hash[direction]
        return x,y,direction
        

#TC: O(n)
#SC: O(1)
class Solution:
    def isRobotBounded(self, instructions: str) -> bool:
        x,y=0,0
                # N(0)   E(1)  S(2)    W(3)
        dir_arr=[(0,1),(1,0),(0,-1),(-1,0)]
        d=0
        for i in range(0, 4):
            for ins in instructions:
                if ins=="G":
                    x=x+dir_arr[d][0]
                    y=y+dir_arr[d][1]
                elif ins=="L":
                    d=(d+3)%4
                else:
                    d=(d+1)%4
            if (x,y) ==(0,0):
                return True
        return False

            