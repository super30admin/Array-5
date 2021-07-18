""" Robot Bounded In Circle
Time Complexity - O(N)
SC - O(1)"""
class Solution:
    def isRobotBounded(self, instructions: str) -> bool:
        dir = [[0,1],[-1,0],[0,-1],[0,1]]#NESW
        d = 0
        x = 0
        y = 0
        for i in instructions:
            if i =='L':
                d = (d + 3)%4
            elif i =='R':
                d = (d+1)%4
            else:# i is G and robot walks straight line
                x +=dir[d][0]
                y +=dir[d][1]
        # return True if robot is back at origin or if its not facing North
        return ( x==0 and y ==0) or d!=0
