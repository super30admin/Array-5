class Solution:
    def calculateTax(self, taxBracket: List[List[int]], income: int) -> float:
        '''
        Time complexity -s O(N), N --> number of tax brackets. The loop iterates through each tax bracket once.
        Space Complexity - O(1)
        '''
        # Check if the taxBracket is empty, in which case no tax is applicable
        if not taxBracket:
            return 0.0

        tax = 0.0  # Initialize the tax amount to 0
        prev_upper = 0  # Initialize the upper bound of the previous tax bracket

        # Iterate through each tax bracket to calculate the tax amount
        for upper, rate in taxBracket:
            # Calculate the taxable income within the current tax bracket
            taxable_income = min(upper, income) - prev_upper

            # If the taxable income is positive, calculate the tax amount and add it to the total
            if taxable_income > 0:
                tax += taxable_income * (rate / 100)

            prev_upper = upper  # Update the previous upper bound for the next iteration

        return tax
