package main

import (
	"fmt"
	"math"
)

/*
Write a program to calculate tax if Salary and Tax Brackets are given as list in the form
[ [10000, .3],[20000, .2], [30000, .1], [None, .1]].
You don’t know in the beginning how many tax brackets are there.
You have to test for all of them

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
}

Input:

levels = [
	[10000.0, 0.3],
	[20000.0, 0.2],
	[30000.0, 0.1],
	[null, 0.1],
]
- represented as [ $taxBracket, $percentToTax ]
Salary = 45000
*/

// time: o(n) - where n is the number of tax brackets in levels
// -- but realistically o(1) since there are only handful number of tax brackets.
// space: o(1)
func taxCalc(levels [][]float64, salary float64) float64 {
	totalTax := 0.0
	currLevel := 0
	prevLevel := -1
	for salary > 0 {
		taxBracket := levels[currLevel][0]
		taxRate := levels[currLevel][1]
		if taxBracket == null {
			totalTax += salary * taxRate
			return totalTax
		}

		if prevLevel != -1 {
			taxBracket = levels[currLevel][0] - levels[prevLevel][0]
		}
		taxableIncome := math.Min(taxBracket, salary)
		totalTax += taxableIncome * taxRate
		salary -= taxableIncome
		prevLevel = currLevel
		currLevel++
	}
	return totalTax
}

const (
	null float64 = 0.0 // implying --- 0.0 is our null case
)

func main() {
	fmt.Println(taxCalc([][]float64{
		{10000.0, 0.1},
		{20000.0, 0.2},
		{30000.0, 0.3},
		{null, 0.4},
	}, 45000.0))
}
