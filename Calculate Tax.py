class Solution:
    def calculateTax(self, levels, salary):
        #Approach: Iterative // linear traversal
        #Time Complexity: O(n) // or O(1) if n is fixed
        #Space Complexity: O(1)
        #where, n is the number of levels
        
        remaining = salary
        prev_level = 0
        total_tax = 0
        
        i = 0
        while remaining > 0:
            level, ratio = levels[i]
            if not level:
                level = inf
                
            taxable = min(remaining, level - prev_level)
            tax = taxable * ratio
            total_tax += tax
            
            remaining -= taxable
            prev_level = level
            i += 1
            
        return total_tax

#Driver code
levels = [[10000, .1], [20000, .2], [30000, .3], [None, .4]]
salary = 45000

sol = Solution()
print(sol.calculateTax(levels, salary))