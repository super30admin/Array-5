'''
Time Complexity: 0(n) --- as tax slabs are limited so constant i.e. 0(1)
Space Complexity: 0(1)
'''
class TaxCalculator:

    def __init__(self):
        pass

    def computeTax(self, levels, salary):
        # total tax paid
        totalTax = 0
        
        # initialize ptrs
        leftAmt = salary
        prevAmt = 0
        taxableAmt = 0  # current level pair
        taxAmt = 0
        
        # iterate the lvl
        for i in range(0,len(levels)):
            
            if leftAmt < 0:
                break
            
            bracket = levels[i]
            
            # update thr taxable amt
            if bracket[0] == None:
                taxableAmt = leftAmt
            else:
                taxableAmt = min((bracket[0]-prevAmt),leftAmt)
            
            # update the leftAmt
            leftAmt = leftAmt-prevAmt
            
            # update the taxAmt
            taxAmt = taxableAmt*bracket[1]
            
            # update the totalTax
            totalTax += taxAmt
            
            # update the prevAmt
            prevAmt = bracket[0]
            
        return totalTax
if __name__ == '__main__':

    #   initializations and function calls
    levels = []
    levels.append([10000.0, 0.1])
    levels.append([20000.0, 0.2])
    levels.append([30000.0, 0.3])
    levels.append([None, 0.4])

    tc = TaxCalculator()
    tax = tc.computeTax(levels, 45000)
    print(tax) 