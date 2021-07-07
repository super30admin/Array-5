# Time Complexity : O(1) as tax slabs are limited in range in real life 
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution:
    def __init__(self, slab):
        self.slab = slab 
    def calculate(self,salary):
        if salary == 0:
            return 0 
        last = 0 
        i = 0
        result = 0         
        while salary > 0 and i < len(self.slab):
            tax_amt, tax_per = self.slab[i]
            if tax_amt == None :
                result += salary * tax_per
                return result 
            else:
                taxable_amt = min(salary, tax_amt - last)
                salary -= taxable_amt 
                last = tax_amt
                result += taxable_amt * tax_per 
            i += 1 

        return result 
            
if __name__ == "__main__":
    tax = [[10000, 0.3], [20000, 0.2], [30000, 0.1], [None, 0.1]]
    s = Solution(tax)

    # Test case 1 
    res1 = s.calculate(45000)
    print(res1)
    
    # Test case 2 
    res2 = s.calculate(25000)
    print(res2)
    

    