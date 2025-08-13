from typing import List
class Solution:
    def calculateTax(self, brackets: List[List[int]], income: int) -> float:
        lower = 0
        tax = 0.0
        idx = 0
        while income>0:
            upper = brackets[idx][0]
            percent = brackets[idx][1]
            idx+=1
            taxable = min(income, upper-lower)
            tax+=taxable*(percent/100)
            lower = upper
            income -= taxable
        return tax
        