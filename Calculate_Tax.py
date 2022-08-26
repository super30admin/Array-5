# Time Complexity : O(n).
# Space Complexity : O(1);
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#
from typing import List


class Solution:
    def calculateTax(self, brackets: List[List[int]], income: int) -> float:
        remaining = income
        limit = 0
        ptr = 0
        tax = 0
        while remaining > 0:
            percent = brackets[ptr][1] / 100
            amount = brackets[ptr][0] - limit
            taxable = min(amount, remaining)
            tax += taxable * percent
            remaining -= amount
            limit = brackets[ptr][0]
            ptr += 1
        return tax


print(Solution().calculateTax([[3, 50], [7, 10], [12, 25]], 10))
