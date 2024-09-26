#Time complexity : O(1)
#Space complexity: O(1)
#Works on leetcode : yes
#Approach : We keep track of total tax and prev tax bracket. Unless it's final tax bracket, we get minimum of remaining salary
#and current tax slab and add the calculated tax of current tax slab to the total. At final tax bracket, we just get tax from
#whatever salary is remaining

def calculatetax(salary, taxbrackets):
	if not taxbrackets or len(taxbrackets) == 0 or salary == 0:
		return 0
	totaltax, prev,  = 0,0
	for tax in taxbrackets:
		if tax[0] is not None:
			current = min(salary, tax[0]-prev)
			totaltax += current*tax[1]
		else:
			totaltax += (salary )*tax[1]
			return totaltax 
		prev = tax[0] 
		salary -= current 
		

print(calculatetax(25000, [[10000,0.1],[20000,0.2],[30000,0.3],[None,0.4]]))
print(calculatetax(45000, [[10000,0.1],[20000,0.2],[30000,0.3],[None,0.4]]))
