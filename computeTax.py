#TC:O(n), n is the number of slabs in taxBrackets-->O(1)
#SC:O(1)
#Ran successfully :Yes
#Formula for taxable=min(ceiling-prev,left)*percentage of tax
class TaxCalculator (object):
    def __init__ (self, taxBracket):
        self.taxBracket = taxBracket
        # self._init()

    def computeTax (self, salary):

        if not self.taxBracket or len(self.taxBracket) == 0 or salary == 0:
            return 0
        prev=0
        left=salary
        taxable=0
        totalTax=0
        temp=0
        for i in range(len(self.taxBracket)):
           
            
            # print(prev,left,taxBracket[i][0],taxable,totalTax)
            if i>0:
                prev=taxBracket[i-1][0]
            if  taxBracket[i][0] is not None:
                temp=(taxBracket[i][0]- prev)
                taxable=min(temp,left)
            else:
                taxable=left
            
            left=salary-taxable
            totalTax+=taxable*taxBracket[i][1]
        # print(totalTax)
        return totalTax
        


#       



taxBracket = [[10000, .1], [20000, .2], [30000, .3], [None, .4]]
taxCalculator = TaxCalculator(taxBracket)

print( taxCalculator.computeTax(25000))
