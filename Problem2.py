"""
Write a program to calculate tax if Salary and Tax Brackets are given as list in the form [ [10000, .1],[20000, .2], [30000, .3], [None, .4]]. You don’t know in the beginning how many tax brackets are there. You have to test for all of them
"""

def calculateTax(amount):
    levels = [[10000, .1],[20000, .2], [30000, .3], [None, .4]]
    tax = 0
    left = amount
    
    i = 0 #to iterate over levels
    lowerBound = 0 #initial lowerbound of current range
    
    while left > 0:
 
        upperBound = levels[i][0]
    
        if upperBound:
            taxable = min(left, upperBound - lowerBound) #min of amount left and the range
        else:
            taxable = left #beyond 30k, remaining amount taxed at .4
        tax += taxable * levels[i][1]
        if upperBound:
            i += 1
        left -= taxable
        lowerBound = upperBound
        
    return tax

print(calculateTax(45000))
    
