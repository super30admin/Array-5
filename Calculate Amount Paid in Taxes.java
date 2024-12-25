//tc- O(1)
// class Solution {
//     public double calculateTax(int[][] brackets, int income) {
//         double tax = 0;
//         int lower = 0;
//         int idx = 0;

//         while(income > 0){
//             int[] br = brackets[idx];
//             idx++;
//             int upper = br[0];
//             int percent = br[1];

//             int taxable = Math.min(income, upper - lower);
//             tax += taxable * percent/100.00;

//             lower = upper;
//             income = income - taxable; 
//         }
//     return tax;    
//     }
// }
//recurssion
class Solution {
    int idx = 0;
    int lower = 0;
    public double calculateTax(int[][] brackets, int income) {
       
       if(income <= 0) return 0;
    
            int[] br = brackets[idx];
            idx++;
            int upper = br[0];
            int percent = br[1];

            int taxable = Math.min(income, upper - lower);
            double tax = taxable * percent/100.00;

            lower = upper;
            income = income - taxable; 

           tax += calculateTax(brackets, income);
           return tax;    
    }
}