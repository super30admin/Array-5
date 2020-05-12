'''
Solution:
1.  Iterate over until some salary is left and at max we reach the last level.
2.  For each level, at max the taxable amount will be the size of that level.
3.  If either salary is over, or if the levels are complete, return the final tax amount calculated.

Time Complexity:    O(levels)
Space Complexity:   O(1)
--- Passed some custom testcases successfully.
'''


class TaxCalculator:

    def __init__(self):
        pass

    def computeTax(self, levels, salary):

        #   initializations
        remainingSalary = salary
        tax = 0
        currentLevel = 0
        previousTaxAmount = 0

        #   iterate until you have some salary remaining
        while (remainingSalary > 0):

            #   current level and percent
            level = levels[currentLevel]
            percent = level[1]

            #   if its last level => calculate percent over the left over salary
            if (level[0] == None):
                tax += (remainingSalary * percent)
                return tax

            #   upper bound amount and taxable salary at current level
            upperLimitAmount = level[0]
            taxableSalaryAtLevel = min(remainingSalary, upperLimitAmount - previousTaxAmount)

            #   add to total tax seen so far, update left over salary and current level
            tax += (taxableSalaryAtLevel * percent)
            remainingSalary -= taxableSalaryAtLevel
            previousTaxAmount = upperLimitAmount
            currentLevel += 1

        #   return the tax
        return tax

if __name__ == '__main__':

    #   initializations and function calls
    levels = []
    levels.append([10000.0, 0.1])
    levels.append([20000.0, 0.2])
    levels.append([30000.0, 0.3])
    levels.append([None, 0.4])

    tc = TaxCalculator()
    tax = tc.computeTax(levels, 45000)
    print(tax)