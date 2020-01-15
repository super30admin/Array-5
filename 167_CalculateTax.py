'''
 Recursive approach
 time - O(N)
 space O(N), when considering recursive stack.
 Approach:
1. provide 3 inputs to the recursive function (index, salary, limit)
index = is for levels
salary = each time the taxable is substracted and remaining salary is returned.
limit = on what amount the tax is applicable for.
2. on each recursion calculate tax by multiplying taxable and perc of tax.
3. Base case is if the taxable is None or salary is less than taxable
then just multiply remaining salary and perc at that point
4. At the end add all tax and return total tax
'''

class Solution:
    def __init__(self):
        self.levels = [[10000,0.3],[20000, 0.2],[30000,0.1],[None, 0.1]]

    def calcTax(self, index, salary, limit):
        perc = self.levels[index][1]
        taxable = None if self.levels[index][0] == None else self.levels[index][0] - limit

        # base case
        if taxable == None or salary < taxable:
            return salary * perc

        #recursive case
        tax = self.calcTax(index+1, salary - taxable, self.levels[index][0])
        tax += taxable * perc

        return tax

sol = Solution()

print(sol.calcTax(0, 25000, 0))


