def calcTax(levels,salary):
    tax = 0.0
    left = salary
    limit = 0.0
    taxableIncome = 0
    i=0
    while (left > 0):
        level = levels[i]
        pecent = level[1]
        if (level[0] == None):
            tax += left * pecent
            return tax
        taxableIncome = min(level[0] - limit, left)
        tax += taxableIncome*pecent
        limit = level[0]
        left = left - taxableIncome
        i = i + 1
    return tax

levels = [[1000.0,0.1],[2000.0,0.2],[3000.0,0.3]]
calcTax(levels,5000)

