#Time: O(1) tax brackets will be constant levels
#Space: O(1)
class TaxCalculator:

    def __init__(self):
        pass

    def computeTax(self, levels, salary):

        #   initializations
        remainingSalary = salary
        tax = 0
        currentLevel = 0
        previousTaxAmount = 0

        #   iterate until you have some salary remaining
        while (remainingSalary > 0):

            #   current level and percent
            level = levels[currentLevel]
            percent = level[1]

            #   if its last level => calculate percent over the left over salary
            if (level[0] == None):
                tax += (remainingSalary * percent)
                return tax

           
            upperLimitAmount = level[0]
            taxableSalaryAtLevel = min(remainingSalary, upperLimitAmount - previousTaxAmount)

            
            tax += (taxableSalaryAtLevel * percent)
            remainingSalary -= taxableSalaryAtLevel
            previousTaxAmount = upperLimitAmount
            currentLevel += 1

        
        return tax

if __name__ == '__main__':

    #   initializations and function calls
    levels = []
    levels.append([10000.0, 0.1])
    levels.append([20000.0, 0.2])
    levels.append([30000.0, 0.3])
    levels.append([None, 0.4])

    tc = TaxCalculator()
    tax = tc.computeTax(levels, 45000)
    print(tax)
