//
//  CalculateAmountPaidInTaxes.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 3/24/26.
//

class AmountPaidInTaxes {
    
    init() {
        
    }
    
    func calculateTax(_ brackets: [[Int]], _ income: Int) -> Double {
        var i = 0
        var remainingAmount: Double = Double(income)
        var tax: Double = 0
        var prev = 0

        while (remainingAmount > 0) {
            let bracket = brackets[i]
            let percent: Double = Double(bracket[1]) / 100.0
            let curr = bracket[0] //3 1st bracket, 1st eg
            let taxable = min(Double(curr - prev), remainingAmount)
            tax = tax + Double(percent * taxable)
            remainingAmount = Double(remainingAmount) - taxable
            prev = curr
            i += 1
        }
        return tax
    }
}
