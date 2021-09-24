#Time complexity : O(N) N:len(instructions)
#space complexity : O(1)
class Solution:
    def isRobotBounded(self, instructions: str) -> bool:
        if len(instructions)==0 or instructions=='':
            return True
        x =0
        y = 0
        direct = 0
        dirs = [[0,1],[1,0],[0,-1],[-1,0]]#north,east,south , west
        for index,item in enumerate(instructions):
            #g
            if item =='G':
                x+=dirs[direct][0]
                y+=dirs[direct][1]
            elif item =='L': #just change direction
                direct = (direct+3)%4
            else:
                direct = (direct+1)%4
        return (x==0 and y==0) or direct!=0   #after one cycle if robot return to origin return true or if robot doesnt face north then also it will be true