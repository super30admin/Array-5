"""
TC: O(n)
SP: O(1)
"""
class Solution:
    def calculateTax(self, brackets: List[List[int]], income: int) -> float:
        tax = 0
        prev = 0
        for u, p in brackets:
            if income > 0:
                tax += min(u - prev, income) * p / 100
                income -= u - prev
                prev = u
            else:
                break
        return tax
