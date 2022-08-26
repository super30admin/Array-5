# Time Complexity : O(n).
# Space Complexity : O(1);
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#
class Solution:
    def isRobotBounded(self, instructions: str) -> bool:
        dirs = [[0, 1], [1, 0], [0, -1], [-1, 0]]
        ptr = 0
        position = [0, 0]
        direction = [0, 1]
        for i in instructions:
            if i == 'G':
                position[0] += dirs[ptr][0]
                position[1] += dirs[ptr][1]
            elif i == 'L':
                ptr = (ptr+3) % 4
                direction = dirs[ptr]
            elif i == 'R':
                ptr = (ptr+1) % 4
                direction = dirs[ptr]
        if position == [0, 0]:
            return True
        elif direction != [0, 1]:
            return True
        return False


print(Solution().isRobotBounded("GGLLGG"))


# class Solution:
#     def isRobotBounded(self, instructions: str) -> bool:
#         dirs = [[0, 1], [1, 0], [0, -1], [-1, 0]]
#         ptr = 0
#         position = [0, 0]
#         direction = [0, 1]
#         for _ in range(4):
#             for i in instructions:
#                 if i == 'G':
#                     position[0] += dirs[ptr][0]
#                     position[1] += dirs[ptr][1]
#                 elif i == 'L':
#                     ptr = (ptr+3) % 4
#                     direction = dirs[ptr]
#                 elif i == 'R':
#                     ptr = (ptr+1) % 4
#                     direction = dirs[ptr]
#             if position == [0, 0]:
#                 return True
#         return False
#
#
# print(Solution().isRobotBounded("GGLLGG"))
