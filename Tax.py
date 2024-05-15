#TC: O(n)
#SC: O(1)
class Solution:
    def calculateTax(self, brackets: List[List[int]], income: int) -> float:
        total=0
        uppr=0
        for b in brackets:
            if income>0:
                if (b[0]-uppr) > income:
                    total+=(income*b[1]/100)
                else:
                    total+=((b[0]-uppr)*b[1]/100)
                income=income-(b[0]-uppr)
                uppr=b[0]
        
        return total