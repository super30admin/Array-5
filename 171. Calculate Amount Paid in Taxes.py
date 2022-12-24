class Solution:
    def calculateTax(self, brackets: List[List[int]], income: int) -> float:
        left = income
        tax = 0
        bracket_tax = 0

        for index, bracket in enumerate(brackets):
            if index == 0 or bracket[0] is None:
                upper = bracket[0]
            else:
                upper = brackets[index][0] - brackets[index - 1][0]

            upper = min(upper, income) if upper is not None else income
            bracket_tax = upper * (bracket[1] / 100)
            tax += bracket_tax
            income = income - upper

            if income <= 0:
                break

        return tax

# Time Complexity:O(n)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No