
# Tax calculator
# // Time Complexity : O(N)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


levels = [[10000.0, 0.1], [20000.0, 0.2], [30000.0, 0.3], [None, 0.4]]


def calculateTax(levels, salary):
    tax=0
    level=0

    for i in levels:
        if (salary<1):
            break
        if (i[0]==None ):
            tax+=salary*i[1]
            break
        else:
            level = min(i[0]-level, salary)
            if (salary >0):
                current = level * i[1]
                tax += current
                salary-=level
            else:
                break
        level=i[0]
    return tax

print(calculateTax( levels, 42000.0))