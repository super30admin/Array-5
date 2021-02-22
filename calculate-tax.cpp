//Time - O(1)
//Space - O(1)
class Solution {
public:
    double calculateTax(vector<vector<double>> levels, double salary) {
        double remaining = salary, percent = 0.0, tax = 0.0;
        int prevLimit = 0;
        int slab = 0;
        
        while(remaining>0){
            percent = levels[slab][1];
            if(slab == levels.size()-1){
                tax = tax + remaining*percent;
                return tax;
            }
            double slabAmount = levels[slab][0]-prevLimit;
            tax = tax + min(remaining, slabAmount)*percent;
            prevLimit = levels[slab][0];
            remaining = remaining - slabAmount;
            slab++;
        }
        return tax;   
    }
};
