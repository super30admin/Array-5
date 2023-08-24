# Time Complexity : O(1)
# Space Complecity : O(1)
# The code ran on LeetCode
# Calculate the tax on money that falls in each bracket 

class Solution:
    def calculateTax(self, brackets: List[List[int]], income: int) -> float:

        idx = 0; prev = 0
        tax = 0
        while income > 0:
            taxable = min(income, brackets[idx][0] - prev)
            percentage = brackets[idx][1]/100
            tax += taxable*percentage
            income -= taxable
            prev = brackets[idx][0]
            idx+=1
        return tax