# S30 Problem #171 Calculate Amount Paid in Taxes
#LeetCode #2303. https://leetcode.com/problems/calculate-amount-paid-in-taxes/description/

# Author : Akaash Trivedi
# Time Complexity : O(1) number of tax bracket is constant
# Space Complexity : O(1)
# Did this code successfully run on Leetcode :  Yes #
# Any problem you faced while coding this : No

# calculate the amount of income for each tax bracket (current limit)
# for that limit calulate the percent of tax, add to total tax
# update the income by remove the current limit, if income is left then cal for next bracket

class Solution:
    def calculateTax(self, brackets: List[List[int]], income: int) -> float:
        currTaxable = 0
        tax = 0
        i = 0
        while income > 0:
            percent = brackets[i][1] / 100  # current precent
            limit = brackets[i][0]
            if i > 0:
                limit = brackets[i][0] - brackets[i - 1][0]
            currTaxable = min(income, limit)
            tax += currTaxable * percent
            income -= limit
            i += 1
        return tax