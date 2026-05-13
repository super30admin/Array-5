# Problem 2 

'''
Write a program to calculate tax if Salary and Tax Brackets are given as list in the form [ [10000, .3],[20000, .2], [30000, .1], [None, .1]]. You don’t know in the beginning how many tax brackets are there. You have to test for all of them
'''

class Solution:
    def calculateTax(self, brackets: List[List[int]], income: int) -> float:
        tax_payment = 0
        remaining_money = income
        last_limit = 0
        for limit,rate in brackets:
            if remaining_money <= 0:
                break
            curr_bracket = limit - last_limit
            if curr_bracket < remaining_money:
                tax_payment = tax_payment + (curr_bracket*rate)/100
                remaining_money = remaining_money - curr_bracket
                last_limit = limit
            else:
                tax_payment = tax_payment + (remaining_money*rate)/100
                remaining_money = 0
        return tax_payment