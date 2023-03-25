class Solution {
    public double calculateTax(int[][] brackets, int income) {
        //Go over all the brackets
        //Time: O(number of brackets)
        //Space: Constant
        if(income == 0){
            return 0.0;
        }
        int deducted = income;
        double total_tax = 0;
        for(int i = 0; i < brackets.length; i++){

            int[] bracket = brackets[i];
            int curr_bound = bracket[0];
            double percentage = bracket[1];
            percentage = percentage/ 100;
            if(deducted > 0){

                if(i == 0){
                    int to_deduct = curr_bound;
                    to_deduct = Math.min(deducted, to_deduct);
                    deducted -= to_deduct;
                    
                    double tax = percentage * to_deduct;
                    total_tax += tax; 
                }

                else{
                    int[] prev_bracket = brackets[i - 1];
                    int prev_bound = prev_bracket[0];
                    int to_deduct = curr_bound - prev_bound;
                    to_deduct = Math.min(to_deduct, deducted);
                    deducted -= to_deduct;
                    double tax = percentage * (to_deduct);
                    total_tax += tax;
                }



            }

            else{
                return total_tax;
            }

            

        }

        return total_tax;
    }
}