#Approach
#We Try to execute the instructions and find the final direction of instructions if it is same as the intial N direction then theere will not be the circle else circle.


#Complexities
#Time: O(N)
#Space: O(1)


class Solution:
    def isRobotBounded(self, instructions: str) -> bool:

        directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]  # NESW
        result = (0, 0)
        direction = 0
        for ins in instructions:
            if ins == "G":
                result = (result[0] + directions[direction][0], result[1] + directions[direction][1])
            elif ins == "L":
                direction = (direction + 3) % 4
            elif ins == "R":
                direction = (direction + 1) % 4
        if direction != 0 or result[0] == 0 and result[1] == 0:
            return True
        return False


