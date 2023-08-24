
'''
Problem: Calculate Amount Paid in Taxes
Time Complexity: O(n), where n is given brackets
Space Complexity: O(1)
Did this code successfully run on Leetcode: Yes
Any problem you faced while coding this: No
Your code here along with comments explaining your approach:
        for every bracket get taxable income and percent
        taxable income is minimum of income and range 
'''


class Solution:
    def calculateTax(self, brackets: List[List[int]], income: int) -> float:
        tax = 0
        prev = 0
        for b in brackets:
            curr = b[0]
            percent = b[1]/100
            taxable = min(income, curr - prev )
            tax += taxable * percent

            income = income - taxable
            prev = curr
        
        return tax

