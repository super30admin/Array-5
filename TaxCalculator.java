import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TaxCalculator {
    // TC : O(1) even though we're iterating over a list, for any financial system it'll always be fixed
    // SC : O(1)
    public double calculateTax(List<List<Double>> taxSlabs, double salary ){
        int i=0;
        double limit = 0;
        double tax = 0;
        double left = salary;
        while(left > 0) {
            List<Double> taxSlab = taxSlabs.get(i);
            double percentage = taxSlab.get(1);
            if(taxSlab.get(0) == null) {
                tax += left * percentage;
                break;
            }
            // because we might not have left with the less amount than the limit
            double taxableIncome = Math.min(taxSlab.get(0) - limit, left);
            tax += taxableIncome * percentage;
            left = left - taxableIncome;
            limit = taxSlab.get(0);

            i++;
        }
        return tax;
    }

    public static void main(String[] args) {
        TaxCalculator calculator = new TaxCalculator();
        List<List<Double>> taxSlabs = new ArrayList<>();
        taxSlabs.add(Arrays.asList(10000.0, 0.1));
        taxSlabs.add(Arrays.asList(20000.0, 0.2));
        taxSlabs.add(Arrays.asList(30000.0, 0.3));
        taxSlabs.add(Arrays.asList(null, 0.4));

        System.out.println("Total tax = " + calculator.calculateTax(taxSlabs, 25000.0));
    }
}
