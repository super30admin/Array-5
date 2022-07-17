/**
Problem: https://github.com/Vaishnavik22/Array-5
*/
// TC: O(n) where n = number of tax slabs. If n is finite, then TC = O(1)
// SC: O(1)
public class Main {
    private static double computeTax(List<Double[]> taxSlabs, double salary) {
        double taxes = 0;
        Double prevTaxLevel = 0.0;
        
        int i = 0;
        while (salary > 0) {
            Double taxSlab[] = taxSlabs.get(i);
            Double curTaxLevel = taxSlab[0];
            Double taxPercentage = taxSlab[1];
            
            if (curTaxLevel == null) {
                taxes += (salary * taxPercentage);
                break;
            }
            double taxableIncome = Math.min(salary, curTaxLevel - prevTaxLevel);
            taxes += (taxableIncome * taxPercentage);
            salary = salary - taxableIncome;
            prevTaxLevel = curTaxLevel;
            ++i;
        }
        return taxes;
    }
    
    public static void main(String[] args) {
        List<Double[]> taxSlabs = new ArrayList<>();
        taxSlabs.add(new Double[]{10000.0, 0.10});
        taxSlabs.add(new Double[]{20000.0, 0.20});
        taxSlabs.add(new Double[]{30000.0, 0.30});
        taxSlabs.add(new Double[]{null, 0.40});
        System.out.println(computeTax(taxSlabs, 45000.0));
        System.out.println(computeTax(taxSlabs, 42000.0));
        System.out.println(computeTax(taxSlabs, 25000.0));
    }
}