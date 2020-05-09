// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach:
1)we start with the logic that if the robot faces either east,west,south directions after traversing the given directions ,when followed the same directions repeatedly then we can reach the origin.
2)If reached then true else we return false.


# Time complexity --> o(n)
# space complexity --> o(1)
class Solution(object):
    def isRobotBounded(self, instructions):
        """
        :type instructions: str
        :rtype: bool
        """
        #we take 0:N,1:E,2:S,3:W , whenever we take a right everytime we get to the next direction but when we reach 3 we have to go 0.so we use mod operator for both left and right operations.
        dir1=0
        dirs=[[0,1],[1,0],[0,-1],[-1,0]]
        x=0
        y=0
        for i in instructions:
            #for right direction it is (dir1+1)%4 to reach the next direction when we take a right.
            if i=='R':
                dir1=(dir1+1)%4
            #for left direction it is (dir1+3)%4 to reach the next direction when we take a left
            elif i=='L':
                dir1=(dir1+3)%4
            else:
                x=x+dirs[dir1][0]
                y=y+dirs[dir1][1]
            # print(dir1,x,y)
            #If the direction is not north and if it reaches the origin then robot can form a circle
        if dir1!=0 or (x==0 and y==0):
            return True
        return False
        