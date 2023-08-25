# Time Complexity : O(n)
# Space Complexity :O(1)
# Passed on Leetcode: yes

class Solution:
    def calculateTax(self, brackets: List[List[int]], income: int) -> float:
        tax = 0

        for i in range(len(brackets)):
            uL = brackets[i][0]
            if  i == 0:
                if income >= uL:
                    taxable = uL
                    tax = tax + (taxable * (brackets[i][1]/100))
                else:
                    taxable = income
                    tax = tax + (taxable * (brackets[i][1]/100))
                    return tax
            else:
                if income >= uL:
                    taxable = brackets[i][0] - brackets[i-1][0]
                    tax = tax + (taxable * (brackets[i][1]/100))
                else:
                    taxable = income - brackets[i-1][0]
                    tax = tax + (taxable * (brackets[i][1]/100))
                    return tax
                    
        return tax