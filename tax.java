class Solution {
    public double calculateTax(int[][] brackets, int income) {
        double res =0.0;
        int m = brackets.length;
        int prev=0;
        for(int i=0;i<m&&income>0;i++){
            int upper=brackets[i][0];
            int percent=brackets[i][1];

            int curr=upper-prev;
            prev=upper;
            int sal=Math.min(income,curr);
            income=income-sal;
            res+=(double)(sal*percent*0.01);
        }
        return res;
    }
}