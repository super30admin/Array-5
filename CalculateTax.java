// Time Complexity: O(n) where n = length of levels
// Space Complexity: O(1)

class GFG {
    private static double calculateTax(List<List<Double>> levels, double salary) {
        double salaryLeft = salary;
        double tax = 0;
        double taxable = 0;
        int i = 0;
        // while condition
        while (salaryLeft > 0) {
            List<Double> level = levels.get(i);
            double percentage = level.get(1);
            // if taxable level is null, need to calculate tax on entire remaining salary
            if (level.get(0) == null) {
                tax += (percentage * salaryLeft);
                break;
            }
            // calculate taxable amount
            taxable = level.get(0) - taxable;
            double currSalary = Math.min(taxable, salaryLeft);
            // calculate tax
            tax += currSalary * percentage;
            // salary left
            salaryLeft -= currSalary;
            taxable = level.get(0);
            i++;
        }

        return tax;
    }
}