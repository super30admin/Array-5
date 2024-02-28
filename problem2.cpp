/*
// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
if the income is greater than the bracket take that amount - prev bracker amount with the given percentage
 and add to the result
 if the income is smaller than the bracker amount find the difference from the last bracket 
 and use the current percentage to find the amount.

*/

#include<vector>
#include<iostream>

using namespace std;

class Solution {
public:
    double calculateTax(vector<vector<int>>& brackets, int income) {
        double tax{};
        int sz = brackets.size();
        double prev{};
        for(int i{};i<sz;++i){
            vector<int> temp = brackets.at(i);
            if(income>temp.at(0)){
                tax= tax + (temp.at(0)-prev)*temp.at(1)/100.00;
                prev = temp.at(0);
            }
            else{
                tax = tax + (income - prev)*temp.at(1)/100.00;
                break;
            }

        }
        return tax;
    }
};