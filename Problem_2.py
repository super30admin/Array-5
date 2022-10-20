"""
Problem2: Calculate Tax

 Write a program to calculate tax if Salary and Tax Brackets are given as list in the form [ [10000, .3],[20000, .2], [30000, .1], [None, .1]]. You don’t know in the beginning how many tax brackets are there. You have to test for all of them 
 
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

"""

class Solution:
    def calculateTax(self, brackets: List[List[int]], income: int) -> float:
        """
        TC = O(N)
        SC = O(1)
        """
        prev, curr, total_tax = 0.0, 0.0 ,0.0
        tax = 0.0
        amount_left = income
        taxable_amt = 0.0
        for elem in brackets:
            curr = elem[0]
            taxable_amt = (curr - prev)
            if taxable_amt <= amount_left:
                amount_left -= taxable_amt
                tax += taxable_amt * (elem[1]/100)
                prev = curr
            else:
                tax += amount_left * (elem[1]/100)
                break
                
        return tax
            
            
            
            
            
            
        