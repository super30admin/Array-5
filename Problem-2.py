#Approach
# for every tax bracet find the taxable amouunt which min income and taxrange and if income greter than zero multiply with percent and add to total tax


#Complexities
#Time: O(n)
#Space: O(1)



from typing import List

class Solution:
    def calculateTax(self, brackets: List[List[int]], income: int) -> float:
        tax = 0
        lower = 0
        i = 0
        while income > 0:
            br = brackets[i]
            i += 1
            upper = br[0]
            percent = br[1]

            taxableAmount = min(income, upper - lower)
            tax += taxableAmount * (percent / 100)
            lower = upper
            income = income - taxableAmount
        return tax


