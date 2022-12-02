"""

## Problem: Calculate Tax.

## Author: Neha Doiphode
## Date:   11-29-2022

## Description:
    Write a program to calculate tax if Salary and Tax Brackets are given as list in the form
    [ [10000, .3],[20000, .2], [30000, .1], [None, .1]].
    You don’t know in the beginning how many tax brackets are there. You have to test for all of them.

    class GFG {
        public static void main (String[] args) {
	            List<List<Double>> levels = new ArrayList<>();
                levels.add( Arrays.asList(10000.0, 0.3) );
                levels.add( Arrays.asList(20000.0, 0.2) );
                levels.add( Arrays.asList(30000.0, 0.1) );
                levels.add( Arrays.asList(null, 0.1) );

                double tax = calculateTax(levels,45000);
                System.out.println(tax);
        }

        public static double calculateTax(List<List<Double>> levels, double salary ){

        }
    }

## Time complexity: O(n), where n is the number of tax brackets given.
                    We only trace thru given brackets once to calculate the final tax amount.

## Space complexity: O(1), no auxiliary space is used.


"""

from typing import List, Optional

def get_input():
    levels = []
    while True:
        print(f"Enter tax bracket info(Upper limit <space> Percent): ")
        upper, percent = input().split()
        level = []
        if upper != 'None':
            level.append(float(upper))
            level.append(float(percent))
        else:
            level.append(None)
            level.append(float(percent))

        levels.append(level)
        print("continue entering more brackets?(y/n): ", end = "")
        choice = input()
        if choice == 'n':
            break

    print("Enter the salary for which you want to calculate the tax: ", end = "")
    salary = float(input())
    return levels, salary

class Solution:
    def calculateTax(self, levels: List[List[int]], salary: int) -> float:
        bracket_tax = 0
        total_tax = 0
        for index, level in enumerate(levels):
            if index == 0 or level[0] == None:
                upper = level[0]
            else:
                upper = levels[index][0] - levels[index - 1][0]
            #print(f"Salary: {salary}")
            upper = min(upper, salary) if upper != None else salary
            bracket_tax = upper *  level[1]
            total_tax += bracket_tax
            salary = salary - upper
            #print(f"upper = {upper}, percent = {level[1]}, bracket_tax = {bracket_tax}")
            if salary <= 0:
                break
        return total_tax

# Driver code
solution = Solution()
levels, salary = get_input()
print(f"Input: Tax brackets: {levels}")
print(f"Input: Salary: {salary}")
print(f"Output: Total tax: {solution.calculateTax(levels, salary)}")