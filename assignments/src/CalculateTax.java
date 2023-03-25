import java.util.*;

public class CalculateTax {

    private static double calculateTax(List<List<Double>> levels, double income) {

        double leftOverIncome = income;
        int i = 0;      // tax bracket level
        double limit = 0;
        double totalTax = 0;

        while (leftOverIncome > 0) {
            List<Double> level = levels.get(i);
            i++;
            double taxPercent = level.get(1);

            if (level.get(0) == null) {
                totalTax += leftOverIncome*taxPercent;
                return totalTax;
            }
            // for cases where income < 10,000 take min
            double taxable = Math.min(leftOverIncome, level.get(0) - limit);
            totalTax += taxable*taxPercent;
            leftOverIncome -= taxable;
            limit = level.get(0);
        }
        return totalTax;
    }

    public static void main(String[] args) {
        List<List<Double>> levels = new ArrayList<>();
        levels.add(Arrays.asList(10000.0, 0.1));
        levels.add(Arrays.asList(20000.0, 0.2));
        levels.add(Arrays.asList(30000.0, 0.3));
        levels.add(Arrays.asList(null, 0.4));
        double tax = calculateTax(levels, 45000);
        System.out.println(tax);
    }
}
