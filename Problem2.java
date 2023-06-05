//Time -> O(1)
//Space -> O(1)

class Solution {
public double calculateTax(int[][] brackets, int income) {
        double tax = 0; 
        int prev = 0;
        for(int[] bracket: brackets){
            if(income <= 0)
                break;
            int diff = Math.min(income, bracket[0] - prev);
            tax += diff * bracket[1]/100.0;
            income = income - diff;
            prev = bracket[0];
        }
        return tax;
    }
}
