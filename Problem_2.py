# Time Complexity: O(n)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

class Solution(object):
    def calculate_tax(salary, brackets):
        tax = 0
        previous_bracket_salary = 0
        for bracket in brackets:
            (bracket_salary, tax_rate) = bracket
            if bracket_salary is None:
                tax += ((salary - previous_bracket_salary) * tax_rate)
                break
            if (salary > bracket_salary):
                tax += ((bracket_salary - previous_bracket_salary) * tax_rate)
            else:
                tax += ((salary - previous_bracket_salary) * tax_rate)
                break
            previous_bracket_salary = bracket_salary
        return tax