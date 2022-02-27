
def calculateTax(levels,amount):
    tax = 0
    low = 0
    taxableAmount = 0
    for level in levels:
        if amount == 0:
            break

        if level[0] is not None:
            taxableAmount = min(level[0]-low,amount)
        else:
            taxableAmount = amount
        tax += taxableAmount * level[1]
        amount -= taxableAmount
        low = level[0]

    return tax


_levels = [[10000,0.1],[20000,0.2],[30000,0.3],[None,0.4]]
print("Salary: 45000",calculateTax(_levels,45000))
print("Salary: 15000",calculateTax(_levels,15000))
print("Salary: 25000",calculateTax(_levels,25000))

