class Problem2303 {
//TC=O(1) as tax brackets are constant
//SC=O(1) as we havent used any extra space    
    public double calculateTax(int[][] brackets, int income) {
        double tax = 0.0;
        int prev = 0;
        int i=0;
        while(income>0){
            int[] curr=brackets[i];
            int taxable=Math.min(income,curr[0]-prev);
            double percent=(double)(curr[1])/100;
            tax+=taxable*percent;
            income=income-taxable;
            prev=curr[0];
            i++;
        }
        return tax;
    }
  public static void main(String[] args) {
        Problem2303 problem=new Problem2303();
        System.out.println(problem.calculateTax(new int[][]{{3,50},{7,10},{12,25}},10));
  }
}
