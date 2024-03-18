// Time Complexity : O(1) as tax slabs are constant in real world
// Space Complexity : O(1)
// Method used : Arrays

public class Main {
    
    private static double computeTaxes(List<List<Double>> taxSlabs, double salary)
    {
        double leftOver = salary;
        double limit = 0.0;
        int i = 0;
        double tax = 0.0;
        double taxableIncome = 0.0;
        
        while(leftOver > 0)
        {
            List<Double> taxSlab = taxSlabs.get(i);
            double taxPercent = taxSlab.get(1);
            
            if(taxSlab.get(0) == null)
            {
                tax = tax + leftOver * taxPercent;
                return tax;
            }
            
            taxableIncome = Math.min(leftOver, taxSlab.get(0) - limit);
            tax = tax + taxableIncome * taxPercent;
            limit = taxSlab.get(0);
            leftOver = leftOver - taxableIncome;
            i++;
        }
        
        return tax;
    }
    
    public static void main(String[] args) {
        
        List<List<Double>> taxSlabs = new ArrayList();
        
        taxSlabs.add(Arrays.asList(10000.0, 0.10));
        taxSlabs.add(Arrays.asList(20000.0, 0.20));
        taxSlabs.add(Arrays.asList(30000.0, 0.30));
        taxSlabs.add(Arrays.asList(null, 0.40));
        
        System.out.println("Total tax deducted is : " + computeTaxes(taxSlabs, 25000) + "$");
        System.out.println("Total tax deducted is : " + computeTaxes(taxSlabs, 45000) + "$");
    }
}