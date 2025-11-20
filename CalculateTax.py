# Time is: O(n) where n is the length of brackets. Space is O(1)

# The intuition is simple, keep calculating the tax until we have reached a bracket where income is greater than that bracket.
# Once we are within the bracket, take the remaining income and calculate tax on that and then return the total tax.

class Solution:
    def calculateTax(self, brackets: List[List[int]], income: int) -> float:
        prevLimit = 0
        tax = 0
        for upper, percent in brackets:
            if income > (upper - prevLimit):
                income = income - (upper - prevLimit)
                tax += (upper - prevLimit)* (percent/100)
                prevLimit = upper
            else:
                tax += income * (percent/100)
                break

        return tax