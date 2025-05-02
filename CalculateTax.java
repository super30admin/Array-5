
//TC: O(1)
//SC: O(1)
class CalculateTax {
    public double calculateTax(int[][] brackets, int income) {
        double sum=0;
        int i=0;
        int previnc=0;
        while(income>0){
            int[] arr=brackets[i];
            int currinc=arr[0]-previnc;
                sum=sum+(Math.min(currinc,income)*arr[1])/100d;
                income=income-currinc;
                previnc=arr[0];
                i++;
        }
        return sum;
    }
}

//can be done using recursion also.