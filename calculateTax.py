# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
def calculateTax(salary, brackets):
    taxes = 0
    for x in brackets:
        if x[0] is not None and salary != 0:
            taxable = min(salary, x[0])
            taxes += taxable * x[1]
            salary -= taxable
        else:
            taxes += salary * x[1]

    return taxes

if __name__ == '__main__':
    Salary = 45000
    Brackets = [
    [10000,0.3],
    [20000,0.2],
    [30000,0.1],
    [None, 0.4]
    ]
    print(calculateTax(Salary, Brackets))
