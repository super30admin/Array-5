#Time complexity : O(N) N:len(levels)
#space complexity : O(1)

def calculateTax(levels, salary):
    pendingsalary = salary
    i = 0
    limit =0
    taxable = 0
    totaltax = 0
    while(pendingsalary>0):
        cur = levels[i][0]
        tax = levels[i][1]
        if cur==None:
            totaltax+=pendingsalary*tax
            return totaltax
        else:
            taxable = min(pendingsalary,(cur-limit))
            totaltax+=taxable*tax
            pendingsalary -=taxable


            limit = cur
            i+=1
    return totaltax
 


print(
    calculateTax([(10000.0, 0.1), (20000.0, 0.2), (30000.0, 0.3), (None, 0.4)],
                 35000))