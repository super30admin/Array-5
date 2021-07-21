# Time:- O(1)
# Space:- O(1)
# Approach:- Iterate through the slabs having an upper and lower_limit describing the slab and calculate
# tax accordingly
def calculate_tax(salary,slabs):
    lower_limit=0
    upper_limit=0
    remaining_salary=salary
    total_tax=0
    for upper_limit,percentage in slabs:
        if not upper_limit:
            upper_limit=salary
        taxable_income=min(remaining_salary,upper_limit-lower_limit)
        if taxable_income<=0:
            break
        total_tax+=percentage*taxable_income
        lower_limit=upper_limit
        remaining_salary=salary-upper_limit
    return total_tax


slabs = [[10000, .1], [20000, .2], [30000, .3], [None, .4]]
salary = 45000
tax = calculate_tax(salary, slabs)
print("Tax {} for salary {}".format(tax, salary))