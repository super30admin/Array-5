import java.util.*;

class GFG {


    public static double calculateTax(List<List<Double>> levels, double salary ){
        //constant time and space
        Double left = salary;
        Double limit = 0.0;
        Double tax = 0.0;

        int i = 0; //index of the bracket
        while(left > 0.0){
            List<Double> level = levels.get(i);
            Double currThreshold = level.get(0);
            Double taxRate = level.get(1);
            if(currThreshold == null){
                tax += taxRate * left;
                return tax;
            }
            Double taxableSalary = Math.min(currThreshold - limit, left);
            tax +=   taxableSalary * taxRate;
            left -= taxableSalary;
            limit  = currThreshold;
            i++;
        }
        return tax;

    }
	public static void main (String[] args) {

		List<List<Double>> levels = new ArrayList<>();

        levels.add( Arrays.asList(10000.0, 0.1) );

        levels.add( Arrays.asList(20000.0, 0.2) );

        levels.add( Arrays.asList(30000.0, 0.3) );

        levels.add( Arrays.asList(null, 0.4) );

        double tax = calculateTax(levels,25000);

        System.out.println(tax);

	}

	
}