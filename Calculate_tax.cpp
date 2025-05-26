// Time Complexity: O(n)
// Space Complexity: O(1)
// Did the code run successfully on LeetCode: Yes

// Approach:
// 1. Iterate through the brackets and calculate the tax for each bracket until the income is exhausted.


class Solution {
public:
    double calculateTax(vector<vector<int>>& brackets, int income) {
        int i = 0; 
        double tax = 0;
        int prevUpperBound = 0;
        while(income > 0){
            vector<int> currBracket = brackets[i];
            int currUpperBound = currBracket[0];
            double percent = currBracket[1];
            int taxableIncomeInCurrBracket = min((currUpperBound - prevUpperBound), income);
            tax += (taxableIncomeInCurrBracket * percent)/100;
            prevUpperBound = currUpperBound;
            income = income - taxableIncomeInCurrBracket;
            i++;
        }
        return tax;
    }
};