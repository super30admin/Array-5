class Solution:
    def calculateTax(self, brackets: List[List[int]], income: int) -> float:
        if len(brackets) == 0:
            return 0
        i = 0 
        left = income
        tax = 0.0
        limit = 0.0
        while left > 0:
            li = brackets[i][0]
            percent = brackets[i][1]
            if li == None:
                tax = tax + (left*percent/100)
                return tax
            tax_income = min(li - limit, left)
            tax = tax + tax_income * percent/100
            i = i +1
            limit = li
            left = left - tax_income
        return tax
    # Tc : O(N)
    # SC : O(1)
    