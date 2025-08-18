# Time Complexity: - O(1) - Only constant number of tax brackets in the real world scenario.
# Space Complexity: O(1)
class Solution:
    def calculateTax(self, brackets: List[List[int]], income: int) -> float:
        tax = 0.0
        lower = 0
        idx = 0

        while income > 0:
            br = brackets[idx]
            idx += 1

            upper = br[0]
            percent = br[1]

            taxable = min(income, upper - lower)
            tax += taxable * (percent / 100.0)

            lower = upper
            income -= taxable

        return tax