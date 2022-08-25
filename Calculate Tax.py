""""// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""

class Solution:
    def calculateTax(self, brackets: List[List[int]], income: int) -> float:
        n = len(brackets)
        result = 0
        limit = 0
        for i in range(n):
            taxable = min(income, brackets[i][0] - limit)
            left = income - taxable
            result += taxable * (brackets[i][1] / 100)
            income = left
            limit = brackets[i][0]
        return result

