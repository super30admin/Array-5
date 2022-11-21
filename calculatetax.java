/*
Time Complexity: O(n*n)
Space Complexity: O(n*n)
*/
class GFG {

public static void main (String[] args) {

	List<List<Double>> levels = new ArrayList<>();

    levels.add( Arrays.asList(10000.0, 0.3) );

    levels.add( Arrays.asList(20000.0, 0.2) );

    levels.add( Arrays.asList(30000.0, 0.1) );

    levels.add( Arrays.asList(null, 0.1) );

    double tax = calculateTax(levels,45000);

    System.out.println(tax);

}

public static double calculateTax(List<List<Double>> levels, double salary ){
double tax = 0d;

        for (Map.Entry<Double, Double> entry : levels.entrySet()) {
            if (salary >= entry.getKey()) {
                tax += entry.getValue() * entry.getKey();
                salary -= entry.getKey();
            } 
            // final residual of tax on highest slab
            else if (tax != 0) {
                tax += entry.getValue() * salary;
                break;
            } 
            // when salary is lesser than first slab
             else {
                return tax;
            }
        }
        return tax;

}
}