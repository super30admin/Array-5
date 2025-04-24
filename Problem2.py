# Problem 2 : Calculate Amount Paid in Taxes
# Time Complexity : O(n) where n is the number of brackets
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
'''
None
'''

# Your code here along with comments explaining your approach

from typing import List
class Solution:
    def calculateTax(self, brackets: List[List[int]], income: int) -> float:
        # define the i which be index for traversing the brackets and set to 0
        i = 0
        # define tax variable to store tax for the income and set to 0.0
        tax = 0.0
        # define prevUpperBound which will store the previous upper bound and initially set to 0
        prevUpperBound = 0

        # loop till income is greater than 0
        while income > 0:
            # get the bracket at ith position in the brackets
            currBracket = brackets[i]
            # get the current upper bound from the current bracket
            currUpperBound = currBracket[0]
            # get the percent from the current bracket
            percent = currBracket[1]

            # get the minimum between values of difference between current and previous upper bound and the income
            taxableIncomeCurrBracket = min(currUpperBound - prevUpperBound, income)
            # calculate the tax as ((taxableIncomeCurrBracket * percent)/ 100.0) and add to current value of tax
            tax += (taxableIncomeCurrBracket * percent) / 100.0

            # set the previous upper bound to current upper bound
            prevUpperBound = currUpperBound
            # subtract the taxableIncomeCurrBracket from income to get the remaining income
            income -= taxableIncomeCurrBracket
            # increment the i
            i += 1
        # return the tax
        return tax
