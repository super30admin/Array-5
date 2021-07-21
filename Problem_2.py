"""
Time Complexity : O(1) - As only finite slabs
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:
Just iterate through the slabs, modify the limit on which tax has to be calculated and add tax
"""


def calculate_tax(salary, slabs):
    lower_limit = 0
    i = 0
    tax = 0
    while salary > 0:
        upper_limit = slabs[i][0]
        tax_percent = slabs[i][1]
        if upper_limit is None:
            tax += (tax_percent*salary)
            return tax
        else:
            salary_slab = min(upper_limit-lower_limit, salary)
            tax += (tax_percent*salary_slab)
            salary -= salary_slab
            lower_limit = upper_limit
        i += 1

    return tax


slabs = [[10000, .3], [20000, .2], [30000, .1], [None, .1]]
salary = 25000
tax = calculate_tax(salary, slabs)
print("Tax {} for salary {}".format(tax, salary))
