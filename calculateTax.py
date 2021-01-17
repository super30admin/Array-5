#Time Complexity : O(1)
#Space Complexity : O(1) 
#Did this code successfully run on Leetcode : Yes

def calculateTax(taxBrackets, salary):
    salaryLeft = salary
    totalTax = 0
    limit = 0
    taxableIncome = 0
    i = 0

    while salaryLeft > 0:
        percentage = taxBrackets[i][1]
        if taxBrackets[i][0] == None:
            totalTax += salaryLeft * percentage
            return totalTax
        taxableIncome = min(taxBrackets[i][0]-limit, salaryLeft)
        totalTax += taxableIncome * percentage
        limit = taxBrackets[i][0]
        salaryLeft -= taxableIncome
        i += 1



    return totalTax


taxBrackets = [[10000, .1],[20000, .2], [30000, .3], [None, .4]]
print(calculateTax(taxBrackets, 45000))
