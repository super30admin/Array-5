// Time Complexity : O(n) where n is the no. of levels
 // O(n logn) if the levels are not sorted. In that case we need to sort it first
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// We go through each level and get the bracket and rate
// We maintain a prev variable which store prev bracket 
// We will get the diff of those and apply tax on that and min of current salary left
// We will update the salary and the prev variables, while keep adding the tax
// Finally we will return the total tax
public class Main {
    public static double calculateTax(List<List<Double>> levels, double salary){
        double tax = 0.0;
        Double prev = 0.0;
        for(List<Double> level: levels){
            Double bracket = level.get(0);
            Double rate = level.get(1);
            double toDeductFrom = (bracket == null)? salary:bracket-prev;
            double taxOn = Math.min(toDeductFrom, salary);
            tax += (taxOn * rate);
            salary -= taxOn;
            if(salary == 0)
                break;
            prev = bracket;
        }
        return tax;

}
    public static void main(String[] args) {
        List<List<Double>> levels = new ArrayList<>();

    levels.add( Arrays.asList(10000.0, 0.3) );

    levels.add( Arrays.asList(20000.0, 0.2) );

    levels.add( Arrays.asList(30000.0, 0.1) );

    levels.add( Arrays.asList(null, 0.1) );

    double tax = calculateTax(levels,100000);

    System.out.println(tax);

    }
}