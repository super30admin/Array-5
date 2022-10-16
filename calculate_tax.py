# Time Complexity : O(1) where N number of instructions
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def calculateTax(self, slabs, amount):
        prevSlab = 0
        tax = 0
        i = 0
        while amount > 0:
            currSlab, rate = slabs[i]
            
            if currSlab == None:
                tax += amount * rate
                return tax
            
            taxableAmount = min(amount, currSlab - prevSlab)
            tax += taxableAmount * rate
            
            amount -= taxableAmount
            prevSlab = currSlab
            i += 1
            
        return tax
        
s = Solution()
print(s.calculateTax([[10000, 0.1], [20000, 0.2], [30000, 0.3], [None, 0.4]], 25000))
print(s.calculateTax([[10000, 0.1], [20000, 0.2], [30000, 0.3], [None, 0.4]], 45000))