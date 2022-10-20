# Time complexity : O(1)
# Space complexity : O(1)
# Leetcode : Solved and submitted

class Solution:
    def calculateTax(self, brackets: List[List[int]], income: int) -> float:
        
        # default values for tax, idx of brackets and prev value
        tax = 0
        idx = 0
        prev = 0
        
        # traverse until the income is not zero
        while income > 0:
            
            # fetch the brackets value
            br = brackets[idx]
            
            # curr is the max value in the bracket and also the percentage
            curr = br[0]
            per = br[1]
            
            # if we have reached the last brackets, then use the full amt for tax
            if idx == len(brackets) - 1:
                tax += income * (per/100.0)
                return tax
            
            # calculate the taxable income corresponding to the current bracket
            taxable = min(curr - prev, income)
            
            # calculate the tax
            tax += taxable * (per/100.0)
            
            # update the prev and income, also the idx
            prev = curr
            income -= taxable
            idx += 1
        
        # return the tax
        return tax
