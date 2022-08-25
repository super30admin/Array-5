class Solution:
    def calculateTax(self, brackets: List[List[int]], income: int) -> float:
        n = len(brackets)
        limit = result = 0
        
        for i in range(n):
            taxable = min(income, brackets[i][0] - limit)
            left = income - taxable
            result += taxable * (brackets[i][1] / 100)
            income = left # remaining income
            if income <= 0:
                return result
            limit = brackets[i][0]
        return result
