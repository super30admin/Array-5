// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach:
In this problem given the block range and their tax percent i.e for [0-10000] it is 0.1 % tax,for [10000-20000] it is 0.2%tax,for [20000-30000] it is 0.3%tax and for the remaining amount it is 0.4 % tax.
For a given amount we go block by block and then calculate the tax amount.
for a given 45000, we start 10000 tax is 1000 and remaining amount is 35000.
in next block for the amount 35000,for the block length 10000 tax is 2000 and remaining is  25000.
For the next block for the amount 25000,the block length is 10000 so tax is 3000 and remaining is 15000.
for remaining 15000 tax is 6000.
Total tax amount is 1000+2000+3000+6000 --> 12000.

Time complexity --> o(n)
space complexity --> o(1)
class solution:
    def computetax(self,tax,amount):
        level=0
        salary=amount
        prev=0
        taxamount=0
        while salary>0:
            val=tax[level]
            currentsalary=val[0]
            taxi=val[1]
            #if the index reaches the last element in the array, then we return the taxamount with salary and tax
            if currentsalary==None:
                taxamount=taxamount+(salary*taxi)
                return taxamount
                #if the salary is more than the given block then we calculate the tax for that block and save the reamining salary for which tax will be calculated in the next cycle.
            currentlevelsal=min(currentsalary-prev,salary)
            #calcualting the tax amount for the given salary block.
            taxamount=taxamount+(currentlevelsal*taxi)
            #saving the remaining salary for the next cycle
            salary=salary-currentlevelsal
            #changing the block
            prev=currentsalary
            level=level+1
        return taxamount


tax=[[10000,0.1],[20000,0.2],[30000,0.3],[None,0.4]]
sol=solution()
print(sol.computetax(tax,25000))
print(sol.computetax(tax,45000))
