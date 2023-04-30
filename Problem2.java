/*
Calculate Tax
approach: for each iteration we have to keep track of left salary, slab, rate, prev limit, curr limit
time & space: O(1)
 */
public class Problem2 {
    private double calculateTax(double salary) {
        double tax = 0;
        Integer[][] slabs = {{10000,10},{20000,20},{30000,30},{null,40}};
        int slabpointer = 0;
        double leftsalary = salary, prevLimit = 0, currLimit = slabs[slabpointer][0], rate = slabs[slabpointer][1];

        while (leftsalary>0) {
            double taxable = Math.min(leftsalary, currLimit-prevLimit);
            tax += taxable*(rate/100);
            leftsalary = leftsalary-taxable;
            prevLimit = currLimit;
            slabpointer++;
            rate = slabs[slabpointer][1];
            if (slabs[slabpointer][0]!=null)
            {
                currLimit = slabs[slabpointer][0];
            }
            else currLimit = leftsalary;
        }

        return tax;
    }

    public static void main(String []args) {
        Problem2 problem2 = new Problem2();
        problem2.calculateTax(25000);
    }
}
