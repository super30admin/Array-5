#just iterate through things and subtract from income till income becomes 0.
#Time and Space COmplexity - O(1)
class Solution:
    def calculateTax(self, brackets: List[List[int]], income: int) -> float:
        i=0
        prev=0
        tax=0
        while income>0:
            taxable=min(income,brackets[i][0]-prev)
            percent=brackets[i][1]/100
            tax+=taxable*percent
            income-=taxable
            prev=brackets[i][0]
            i+=1
        return tax