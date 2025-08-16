class Solution:
    def calculateTax(self, brackets: List[List[int]], income: int) -> float:
        tax = 0
        for i in range(len(brackets)):
            prev = 0
            if i > 0:
                prev = brackets[i - 1][0]
            currTaxableIncome = min((brackets[i][0] - prev), income)
            tax += (currTaxableIncome * (brackets[i][1]/100))
            income = income - currTaxableIncome
            if income == 0:
                return tax
        return -1
            