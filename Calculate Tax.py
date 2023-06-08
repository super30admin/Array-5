class Solution:
    def calculateTax(self, bracket: List[List[int]], salary: int) -> float:
        # Time O(n)
        # Space O(1)
        tax = 0
        dq = collections.deque()
        dq.append(salary)
        i = 0
        prev = 0
        while dq:
            curr = dq.popleft()
            taxable, per = bracket[i]
            taxable = taxable - prev
            prev = bracket[i][0]
            per = per / 100
            if (curr - taxable) <= 0:
                taxable = curr
            tax += (taxable * per)
            curr -= taxable
            if curr > 0:
                i += 1
                dq.append(curr)

        return tax