import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class GFG {

    public static void main(String[] args) {

        List<List<Double>> levels = new ArrayList<>();

        levels.add(Arrays.asList(10000.0, 0.3));

        levels.add(Arrays.asList(20000.0, 0.2));

        levels.add(Arrays.asList(30000.0, 0.1));

        levels.add(Arrays.asList(null, 0.1));

        double tax = calculateTax(levels, 45000);

        System.out.println(tax);
    }

    public static double calculateTax(List<List<Double>> levels, double salary) {
        double tax = 0.0;

        // Sort levels in reverse order based on salary thresholds
        levels.sort((a, b) -> (int) (b.get(0) - a.get(0)));

        for (List<Double> level : levels) {
            Double threshold = level.get(0);
            Double rate = level.get(1);

            if (threshold == null || salary > threshold) {
                // Calculate tax for the current bracket
                double taxableIncome = (threshold != null) ? salary - threshold : salary;
                double bracketTax = taxableIncome * rate;
                tax += bracketTax;

                // Reduce salary by the taxable amount for the next iteration
                salary -= taxableIncome;
            }
        }

        return tax;
    }
}
