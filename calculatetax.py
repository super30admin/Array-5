
"""
	Calculate tax for the current salary.
"""
# Time complexity - O(1) # no of salary slabs are fixed and usually less.
# Space complexity - O(1)
# Did this solution run on leetcode? - N.A.
class Solution:
	def __init__(self, slabs):
		self.slabs = slabs

	def calculate_tax(self, salary):
		lower_limit = 0
		i = 0
		tax = 0
		while salary > 0:
			upper_limit = self.slabs[i][0]
			tax_percent = self.slabs[i][1]

			# calculate tax for the current salary slab.
			if upper_limit is None:
				tax += (tax_percent*salary)
				return tax
			else:
				salary_slab = min(upper_limit-lower_limit, salary)
				# calculate tax by multiplying salary lying in the current slab range with the tax percent.
				tax += (tax_percent*salary_slab)
				salary -= salary_slab
				# assign current upper limit to the next lower limit.
				lower_limit = upper_limit
			i+=1

		return tax


if __name__=='__main__':
	# assuming the slabs array is sorted.
	slabs = [[10000, .3], [20000, .2], [30000, .1], [None, .1]]	
	s = Solution(slabs)
	salary = 25000
	tax = s.calculate_tax(salary)
	print("Tax {} for salary {}".format(tax, salary))