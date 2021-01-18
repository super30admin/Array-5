// Time Complexity: O(1) Since only 4 levels of tax brackets are there.
// Space Complexity: O(1)
double calculateTax(vector<pair<double, double>> levels, double salary) {
    double remSalary = salary;
    double totTax = 0;
    double limit = 0;
    int i = 0;
    
    while(remSalary > 0) {
        pair<double, double> level = levels[i];
        double taxBracket = level.first;
        double percent = level.second;
        //cout << taxBracket << " " << percent << endl;
        if(taxBracket == 0) {
            totTax += remSalary * percent;
            //cout << "Tax: " << totTax << endl;
            return totTax;
        }
        totTax += min(remSalary, taxBracket-limit) * percent;
        //cout << "Tax: " << totTax << endl;
        remSalary -= min(remSalary, taxBracket-limit);
        //cout << "remSalary : " << remSalary << endl;
        limit = taxBracket;
        //cout << "limit : " << limit << endl;
        i++;
    }
    return totTax;
}
int main() {
    vector<pair<double, double>> levels = {{10000, 0.1}, {20000, 0.2}, {30000, 0.3},{0, 0.4}};
    cout << calculateTax(levels, 25000);
    
    return 0;
}
