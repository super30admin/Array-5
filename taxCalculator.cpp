// Time Complexity : O(N)
 // Space Complexity : O(1)
 // Did this code successfully run on Leetcode : Yes
 // Any problem you faced while coding this : NA


 // Your code here along with comments explaining your approach


double calculateTax(vector<vector<double>> levels, double salary) {
    double taxableSalary = 0.0;
    double tax = 0;
    double limit = 0.0;
    
    for(auto level : levels){
        double percent = level[1];
        if(level[0] == NULL){
            tax+=percent*salary;
            return tax;
        }
        taxableSalary = min(level[0]-limit,salary);
        tax+=taxableSalary*percent;
        limit = level[0];
        salary-=taxableSalary;
    }
    return tax;    
}
int main() {
    vector<vector<double>> levels;
    levels.push_back({10000.0, 0.1});
    levels.push_back({20000.0, 0.2});
    levels.push_back({30000.0, 0.3});
    levels.push_back({NULL, 0.4});
    cout<<calculateTax(levels, 25000);
    return 0;
}