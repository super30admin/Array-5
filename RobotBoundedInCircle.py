#All TC passed on leetcode

class Solution:
    def isRobotBounded(self, instructions: str) -> bool:


         #here we store the directions N-E-S-W in clockwise or anticlockwise diretion. We iterate through the instructions array and increment x and y pointers if G, increment direction pointer i if L or R. We repeat tracersing instructions array max 4 times as in 4 or less moves it is possible to return back to origin if its bounded in circle
        #time complexity - O(n) - instructions length
        #space complexity - O(1)
        x = 0
        y = 0
        directions = [[0,1], [1,0],[0,-1], [-1,0]] #in clockwise directions N-E-S-W

        i = 0
        for d in range(4):
            for ch in instructions:
                if ch=="G":
                    x += directions[i][0]
                    y += directions[i][1]
                elif ch=="R":
                    i = (i+1)%4     #to move to N if we are at W
                else:
                    i = (i+3)%4     #to move to W if we are at N
            if (x==0 and y==0):
                return True
        return False


#------------------------------------OR--------------------------------------------


        #here we store the directions N-E-S-W in clockwise or anticlockwise diretion. We iterate through the instructions array and increment x and y pointers if G, increment direction pointer i if L or R.At the end if direction is not pointing to N or x,y are at origin then we return true
        #time complexity - O(n) - instructions length
        #space complexity - O(1)
        x = 0
        y = 0
        directions = [[0,1], [1,0],[0,-1], [-1,0]] #in clockwise directions N-E-S-W

        i=0
        for ch in instructions:
            if ch=="G":
                x += directions[i][0]
                y += directions[i][1]
            elif ch=="R":
                i = (i+1)%4     #to move to N if we are at W
            else:
                i = (i+3)%4     #to move to W if we are at N
        return True if (x==0 and y==0) or i!=0 else False



        