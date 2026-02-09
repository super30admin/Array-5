#  Time Complexity : O(1)   
#  Space Complexity : O(1)  
#  Did this code successfully run on Leetcode : Yes
#  Three line explanation of solution in plain english: This code calculates total tax by iterating through tax brackets and taxing only the portion of income that falls within each bracket. For each bracket, it determines how much of the remaining income can be taxed in that range (upper - lower), applies the bracket’s tax percentage to that amount, and adds it to the total tax. It then reduces the remaining income and moves to the next bracket until all income has been taxed.


class Solution:
    def calculateTax(self, brackets: List[List[int]], income: int) -> float:
        tax  = 0.0
        lower = 0
        idx = 0

        while income > 0:
            br = brackets[idx]
            idx += 1

            upper = br[0]
            percent = br[1]

            taxable = min(income, upper - lower)
            tax += taxable * (percent / 100)

            lower = upper
            income -= taxable

        return tax
