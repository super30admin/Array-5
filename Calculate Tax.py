import collections
bracket = [[10000,0.3],[20000,0.2],[30000,0.1],[None,0.1]]
salary = 80000
tax = 0
dq = collections.deque()
dq.append(salary)
i = 0
while dq:
    curr = dq.popleft()
    taxable, per = bracket[i]
    if taxable == None or (curr-taxable) < 0:
        # taxable = curr
        # curr = 0
        tax += (curr * per)
        break
    tax += (taxable * per)
    curr -= taxable
    print("Tax at ", i, tax, curr)
    if curr > 0:
        i += 1
        dq.append(curr)




print("tax is", tax)