
def calculate_tax(levels, salary):
    ## T.C = O(n)
    ## S.C = O(1)
    
    left_sal = salary
    i = 0
    tax = 0
    prev_limit = 0
    
    while left_sal > 0 and levels[i][0] != None:
        curr_lvl, tx_prcnt = levels[i]
        curr_amt = min(curr_lvl - prev_limit, left_sal)
        tax = tax + (curr_amt*tx_prcnt)
        prev_limit = curr_lvl
        left_sal = left_sal - curr_amt
        i += 1
    
    if left_sal > 0:
        tax = tax + (left_sal*levels[i][1])
    
    return tax
    
    


levels = [[10000, 0.10], [20000, 0.20], [30000, 0.30], [None, 0.40]]
salary = 45000
tax = calculate_tax(levels, salary)
print("Final tax: ", tax)