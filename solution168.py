#Time Complexity:O(n)
#Space Complexity:O(1)
#Approach:parse through the levels of tax, obtain the minimum taxable salary and find the tax to be paid based on the percentage.sum the total
#tax values obtained at different levels and return the tax.

arr=[ [10000, .1],[20000, .2], [30000, .3], [None, .4]]
salary=25000

def calculateTax(levels:List[List[int]],s:int):
    left=s
    i=0
    prev=0
    tax=0
    while left>0:
        level=levels[i]
        percent=level[1]
        if level[0]==None:
            tax+=left*percent
            break
        taxableSalary=min(left,level[0]-prev)
        tax+=taxableSalary*percent
        left=left-taxableSalary
        prev=level[0]
        i+=1
    print(tax)
    
calculateTax(arr,salary)