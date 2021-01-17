"""
TC- 0(1) Finite salary slab 
SC -O(1)

Iterate through the slabs, modify the limit on which we need to calculate tax and keep adding up th etax
"""


def calculate_tax(salary, slabs):
    lowlimit = 0.0
    i = 0 #for levels
    tax = 0
    left=salary
    while left > 0:
        uplimit = slabs[i][0]
        taxpercent = slabs[i][1]
        if uplimit is None:
            tax += (taxpercent*left)
            return tax
    
        taxableIncome = min(uplimit-lowlimit, left)
        tax += (taxableIncome*taxpercent)
        left -= taxableIncome
        lowlimit = uplimit
        i += 1

    return tax


slabs = [[10000, .1], [20000, .2], [30000, .3], [None, .4]]
salary = 5000
tax = calculate_tax(salary, slabs)
print(tax)