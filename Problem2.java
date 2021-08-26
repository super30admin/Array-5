

// time - O(1)
// space - O(1)


public class TaxCalculate {


    public static void main (String[] args) {

        List<List<Double>> levels = new ArrayList<>();

        levels.add( Arrays.asList(10000.0, 0.1) );

        levels.add( Arrays.asList(20000.0, 0.2) );

        levels.add( Arrays.asList(30000.0, 0.3) );

        levels.add( Arrays.asList(null, 0.4) );

        double tax = calculateTax(levels,45000);

        System.out.println(tax);

    }

    private static double calculateTax(List<List<Double>> levels, double salary) {

        double limit = 0;
        double left = salary;
        int i = 0;
        double tax = 0;
        double taxable;
        while(left > 0) {
            List<Double> level = levels.get(i);
//            double currRange = level.get(0);
            double percentage = level.get(1);
            if(level.get(0) == null) { // if it reaches last level which is null in the list
                tax += left * percentage;
                return tax;
            }
            // keep on doing till it reaches last element in the list
            taxable = Math.min(left, level.get(0) - limit);  //
            tax += taxable * percentage;
            left = left - taxable;
            limit = level.get(0);
            i++;
        }

        return tax;

    }


}

