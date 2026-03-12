# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Explanation:
# Iterate through tax brackets.
# For each bracket compute taxable amount within the limit.
# Continue until salary is fully processed.

def calculateTax(levels, salary):
    
    prev = 0
    tax = 0
    
    for limit, rate in levels:
        
        if limit is None:
            tax += (salary - prev) * rate
            break
        
        taxable = min(salary, limit) - prev
        
        if taxable > 0:
            tax += taxable * rate
        
        prev = limit
        
        if salary <= limit:
            break
    
    return tax