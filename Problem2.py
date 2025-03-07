# Problem 2: Calculate Tax

class Solution:
    def calculateTax(self, brackets: List[List[int]], income: int) -> float:
        idx = 0 
        tax = 0
        lower = 0

        while(income > 0):
            br = brackets[idx]
            upper = br[0]
            percent = br[1]
            idx += 1

            taxable = min(income, upper-lower)
            tax += taxable * percent/100

            lower = upper 
            income = income - taxable 

        return tax

        