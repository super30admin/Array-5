#Time = O(n)
#Space = O(1)
# Not available on leetcode
class Solution:
    self.levels = [[10000,0.3],[20000, 0.2],[30000,0.1],[None, 0.1]]

    def calcTax(self, index, salary):
        prev = 0
        tax = 0
        while(salary!= 0):
            if self.levels[index][0] == None: #checking if the level is None then calculate the tax accordingly
                tax += salary * self.levels[index][1]
                return tax

            taxableIncome = min((self.levels[index][0] - prev), salary) #finding the minimum between salary and the difference between levels
            
            tax += taxableIncome * self.levels[index][1] # calculating the tax

            salary -= taxableIncome # updating the salary
            prev = self.levels[index][0]
            index+=1
        return tax
        

sol = Solution()

print(sol.calcTax(0, 45000))