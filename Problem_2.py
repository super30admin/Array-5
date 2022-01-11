def calculateTax(levels, salary):
    i = 0
    limit = 0
    left = salary
    tax = 0
    while left > 0:
        percent = levels[i][1]
        currRange = levels[i][0]
        if currRange == None:
            tax += left * percent
            return tax
        taxable = min(left, currRange - limit)
        tax += taxable * percent
        left -= taxable
        limit = currRange
        i += 1
    return tax




levels = [[10000, 0.1], [20000, 0.2], [30000, 0.3], [None, 0.4]]
print(calculateTax(levels, 45000))
print(calculateTax(levels, 25000))

# Time Complexity: O(n)
# Space Complexity: O(1)