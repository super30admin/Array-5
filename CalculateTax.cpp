/* 
    Time Complexity                              :  O(N) where N is the length of the amountTaxList array
    Space Complexity                             :  O(1)
    Did this code successfully run on Leetcode   :  Yes
    Any problem you faced while coding this      :  No
*/

#include <bits/stdc++.h> 
using namespace std;  


double calculateTax(vector<vector<double>> amountTaxList, double salary) {
    int prevLimit = 0;
    double totalTax = 0;
    double left = salary;
    for(auto amountTax : amountTaxList) {
        double amount = amountTax[0];
        double rate = amountTax[1];
        if(amount == -1.0) {
            totalTax += left*rate;
        } else {
            int taxableIncome = min(left, amount-prevLimit);
            totalTax += taxableIncome*rate;
            prevLimit = amount;
            left -= taxableIncome;
            if(left < 0) {
                return totalTax;
            }
        }
    }
    
    return totalTax;
}

int main() {
    std::cout << "Hello World!\n";
    vector<vector<double>> amountTaxList = {{10000.0,0.1},{20000.0,0.2},{30000.0,0.3},{-1.0,0.4}};
    double salary = 45000.0;
    double totalTax = calculateTax(amountTaxList, salary);
    cout << totalTax << "\n";
}