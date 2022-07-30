TC:O(n) n is the brackets length
SC:O(1)

class Solution {
    public double calculateTax(int[][] brackets, int income) {
        if(income == 0) return 0.00000;
        double tax=0;
        int taxrate =0;
        int taxableamount = 0;
        int prevlimit =0;
        int i=0;
        int left = income;
        while(left>0){
            taxrate = brackets[i][1];
            int curlimit = brackets[i][0];
            taxableamount = Math.min((curlimit - prevlimit),left);
            tax =  tax + taxableamount *taxrate;
            prevlimit = curlimit;
            i++;
            left = left - taxableamount;
        }
        return tax*0.01;
    }
}