import collections
# Time O(n)
# Space O(1)
# bracket = [[10000,0.3],[20000,0.2],[30000,0.1],[None,0.1]]
bracket = [[3,0.5],[7,0.1],[12,0.25]]
salary = 10
tax = 0
dq = collections.deque()
dq.append(salary)
i = 0
prev = 0
while dq:
    curr = dq.popleft()
    taxable, per = bracket[i]
    if taxable == None:
        # taxable = curr
        # curr = 0
        tax += (curr * per)
        curr -= curr
        print("Tax at ", i, tax, curr)
        break

    taxable = taxable - prev
    prev = bracket[i][0]
    if (curr - taxable) <= 0:
        # taxable = curr
        # curr = 0
        tax += (curr * per)
        print("Tax at ", i, tax, curr)
        break
    # per = per / 100

    tax += (taxable * per)
    curr -= taxable
    print("Tax at ", i, tax, curr)
    if curr > 0:
        i += 1
        dq.append(curr)


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



print("tax is", tax)