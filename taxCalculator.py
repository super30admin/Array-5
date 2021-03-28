class Solution:
    
    """
    Description: find total tax from given tax brackets
    
    Time Complexity: O(1)
    Space Complexity: O(1)
    
    Approach:
    - in each step, calculate amount left to tax and keep track of previous amount (starting from 0)
    - when the limit reach None, return the tax by adding up the left amount to the last tax bracket
    """
    
    def calculateTax(taxBrackets, Salary):
        
        left_amount = Salary
        prev_amount = 0; tax = 0

        for bracket in taxBrackets:

            if bracket[0] == None:
                tax += left_amount * bracket[1] 
                return tax

            taxableSalary = min(left_amount, bracket[0] - prev_amount)
            tax += taxableSalary * bracket[1]
            left_amount = left_amount - taxableSalary
            prev_amount = bracket[0]
                
        return tax

s = Solution
taxBrackets = [[10000, 0.1], [20000, 0.2], [30000, 0.3], [None, 0.4]]
print(s.calculateTax(taxBrackets, 25000))
print(s.calculateTax(taxBrackets, 45000))
