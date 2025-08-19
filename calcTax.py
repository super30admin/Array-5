class Solution:
    def calculateTax(self, brackets: List[List[int]], income: int) -> float:
        remaining=income
        lower=0
        total=0

        for upper, percent in brackets:
            if remaining==0:
                break
            amt=min(remaining, upper-lower)
            remaining-=amt
            total+=amt*percent/100
            lower=upper
        
        return total