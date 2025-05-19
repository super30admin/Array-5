#time complexity o(1) (since we have finite number of brackets)
class Solution:
    def calculateTax(self, brackets: List[List[int]], income: int) -> float:
        i = 0
        tax = 0
        prevUpperBound = 0
        while income > 0:
            currBracket = brackets[i]
            upperBound = currBracket[0]
            percent = currBracket[1]
            taxableIncomeInCurrBracket = min((upperBound - prevUpperBound),income)
            tax += (taxableIncomeInCurrBracket * percent/100)
            prevUpperBound = upperBound
            income = income - taxableIncomeInCurrBracket
            i += 1
        return tax