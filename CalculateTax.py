# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach


def calculateTax(levels, salary):
    leftSalary = salary
    prev = 0
    tax = 0
    i = 0
    while leftSalary > 0:
        percent = levels[i][1]
        if levels[i][0] == None:
            tax += leftSalary * percent
            return tax
        taxableSalary = min(leftSalary, levels[i][0] - prev)
        tax += taxableSalary * percent
        print(prev, leftSalary, taxableSalary, tax)
        prev = levels[i][0]
        leftSalary = leftSalary - taxableSalary
        i += 1
    return tax


print(
    calculateTax([(10000.0, 0.1), (20000.0, 0.2), (30000.0, 0.3), (None, 0.4)],
                 35000))
