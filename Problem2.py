# Taxation question S30
# Time: O(n)
# Space: O(1)
def taxation(tax_bracket, salary):
    tot_tax = 0
    prev_slab = 0
    for bracket in tax_bracket:
        if bracket[0] is None or salary <= bracket[0]:
            tot_tax += ((salary-prev_slab)*bracket[1])
            break
        elif salary > bracket[0]:
            tot_tax += ((bracket[0] - prev_slab)*bracket[1])
            prev_slab = bracket[0]
    return tot_tax
            
            
            
            
