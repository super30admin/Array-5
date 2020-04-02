class Solution:

    def calculate_tax(self, levels, salary):
        """
            Time Complexity - O(n)
            Space Complexity - O(1)
        """
        remaining_salary = salary
        prev_limit = tax = 0
        for limit, tax_rate in levels:
            if remaining_salary == 0:
                break
            if not limit:
                tax += remaining_salary * tax_rate
                break
            taxable_income = min(limit - prev_limit, remaining_salary)
            tax += tax_rate * taxable_income
            prev_limit = limit
            remaining_salary -= taxable_income
        return tax

    def calculate_tax_recursive(self, levels, salary):
        return self._helper(levels, 0, salary, 0, 0)

    def _helper(self, levels, index, salary, tax, prev_limit):
        # base
        if salary == 0:
            return tax
        if not levels[index][0]:
            return tax + salary * levels[index][1]
        # logic
        taxable_income = min(levels[index][0] - prev_limit, salary)
        tax += levels[index][1] * taxable_income
        return self._helper(levels, index + 1, salary - taxable_income, tax, levels[index][0])


if __name__ == '__main__':
    tax_levels = [(10000.0, 0.1), (20000.0, 0.2), (30000.0, 0.3), (None, 0.4)]
    print(Solution().calculate_tax(tax_levels, 25000))
    print(Solution().calculate_tax(tax_levels, 45000))
    tax_levels = [(10000.0, 0.3), (20000.0, 0.2), (30000.0, 0.1), (None, 0.1)]
    print(Solution().calculate_tax(tax_levels, 45000))
    print(Solution().calculate_tax_recursive(tax_levels, 45000))
