"""
Time Complexity : O(1)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Explaination
in each iteration resuce the amount by taxable amount
calculate tax on slab range and reduce this from slaary
when we are left with salary less than slab range tax on salary

"""

def calculate_tax(salary, slabs):
    limit = 0 # 0, 1000, 2000
    index = 0 # 0, 1, 2 ,3
    tax = 0
    load =0 
    while index<len(slabs) and salary>0:
        if slabs[index][0] == None:
            tax += salary*slabs[index][1]
            return tax
        else:
            load = min(slabs[index][0]-limit, salary)
        tax += load*slabs[index][1]
        salary -= load
        limit = slabs[index][0]
        index += 1
    return tax

    
    

slabs = [[10000, .1], [20000, .2], [30000, .3], [None, .4]]
salary = 45000
tax = calculate_tax(salary, slabs)
print("Tax {} for salary {}".format(tax, salary))