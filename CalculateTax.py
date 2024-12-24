#Time Complexity: O(n) (where n is the number of tax brackets, as each bracket is processed once).
#Space Complexity: O(1) (constant space used for variables).
class Solution:
    def calculateTax(self, brackets: List[List[int]], income: int) -> float:
        tax=0
        lower=0
        idx = 0
        while(income>0):
            br = brackets[idx]
            upper = br[0]
            percent = br[1]
            taxable = min(income,upper-lower)
            tax += (taxable*percent)/100                
            lower = upper
            income = income-taxable 
            idx+=1
        return tax


        