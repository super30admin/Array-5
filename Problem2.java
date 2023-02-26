/*

Time : O(n)
Space : O(1
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
    
    double income = salary;
    
        double tax = 0.0;
        double prev =0;
        for(int i=0;i<levels.size() && income>0;i++){
            double dollars = 0.0;
            if(levels.get(i).get(0) !=null)
                dollars= levels.get(i).get(0) - prev;
            else 
                 dollars=income;
            if(dollars < income) {
            tax += dollars * (levels.get(i).get(1));
            }
            else{
                tax += income * (levels.get(i).get(1));
            }
            income-=dollars;
            if(levels.get(i).get(0) !=null)
            prev = levels.get(i).get(0);
        }

        return tax;

}
}