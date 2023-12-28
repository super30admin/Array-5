# Time: O(n)
# Space: O(1)
# Did it run on Leetcode: yes

class Solution(object):
    def calculateTax(self, brackets, income):
        """
        :type brackets: List[List[int]]
        :type income: int
        :rtype: float
        """
        i=0
        pending=income
        tax=0
        prevupp=0
        while(pending>0):
            taxable=min(pending, brackets[i][0]-prevupp)
            percent=brackets[i][1]
            tax+=(taxable*percent)/100.0
            pending=pending-taxable
            prevupp=brackets[i][0]
            i+=1
        return tax

        