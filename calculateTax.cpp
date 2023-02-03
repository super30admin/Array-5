// Time complexity: O(n)
// Space complexity: O(1)

class Solution {
    public:
    double calculateTax(vector<vector<double>> levels, double salary) {
        double tax = 0;
        double consideredSalary = 0.0;
        
        for(int i =0; i<levels.size(); i++) {
            vector<double> taxBracket = levels[i];
            if(taxBracket[0] == NULL || consideredSalary + taxBracket[0] >= salary) {
                tax += (salary - consideredSalary) * taxBracket[1];
                return tax;;
            }
            else {
                consideredSalary += taxBracket[0];
                tax+= taxBracket[0] * taxBracket[1];
            }
        }
        return tax;
    }
};



int main() {
	vector<vector<double>> levels {
        {10000.0, 0.3},
        {20000.0, 0.2},
        {30000.0, 0.1},
        {NULL, 0.1}
    };
        
    Solution s;
    double tax = s.calculateTax(levels,45000);
    cout<<tax;
    return 0;
}