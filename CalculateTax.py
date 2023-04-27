#Following all TC passed 
class Solution:
    
    #Here we compute tax amount for each tax level by iterating though each tax level and computing taxable amount for that level
    #Time complexity - O(1) - we iterate through all tax levels which is of fixed length
    #Space complexity - O(1)
    def calculateTax(self, levels, amount):
        i = 0
        prev = 0
        tax = 0
        left_salary = amount
        while left_salary>0:
            if levels[i][0]==None:
                taxable_amt = left_salary
                left_salary -= taxable_amt
            else:
                taxable_amt = min(left_salary, levels[i][0]-prev)
                left_salary -= taxable_amt
            tax += (taxable_amt*levels[i][1])/100
            prev = levels[i][0]
            i+=1
        return tax 
            
            
        
    
    

levels = [[10000, 10], [20000, 20], [30000, 30], [None, 40]]
s = Solution()
result = s.calculateTax(levels, 45000)
print(result)

result = s.calculateTax(levels, 25000)
print(result)

result = s.calculateTax(levels, 15000)
print(result)