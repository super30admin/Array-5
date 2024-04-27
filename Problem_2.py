'''
Time Complexity - O(n)
Space Complexity - O(1)
Works on Leetcode
'''
class Solution:
    def calculateTax(self, brackets: List[List[int]], income: int) -> float:
        amt = 0
        i = 0
        while income > 0:
            # Calculate diff between current upper limit and previous limit and apply rate on the diff
            if i >=1:
                amt = amt + (min(brackets[i][0] - brackets[i-1][0], income) * (brackets[i][1]/100))
                income = income -  min(brackets[i][0] - brackets[i-1][0], income)
            else:
                amt = amt + (min(brackets[i][0], income)*brackets[i][1]/100)
                income = income-min(brackets[i][0], income)
            i+=1
        return amt
        