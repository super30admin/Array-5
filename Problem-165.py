'''
Calculate Tax

time complexity - O(N)
Space complexity - O(N)

Approach - we maintain index, salary,limit in recursive helper function
           1) taxable = levels[index][0]-previous index element/limit
           2) if salary <taxable or taxable == None then salary *percent
           
'''
class solution:
    def tax1(self, levels,salary):
        
        return self.helper(salary,0,0)
        
    def helper(self,salary,index,limit):
        percent= levels[index][1]
        taxable= None if levels[index][0]== None else levels[index][0]-limit
        
        #base case
        if taxable==None or salary<taxable:
            return salary*percent
        tax=self.helper(salary-taxable,index+1,levels[index][0])
        tax+=taxable*percent
        return tax
    
m=solution()
levels=[ [10000, .3],[20000, .2], [30000, .1], [None, .1]]
salary = 25000
print(m.tax1(levels,salary))

