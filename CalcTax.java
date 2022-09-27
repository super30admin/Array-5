
// Time: O(n)
// Space: O(1)

public class Main {
    public static double calculatetax(List<List<Double>> taxslabs, double salary){
        double left = salary;
        double previous = 0;
        double taxable = 0;
        double tax = 0;
        
        int i = 0;
        while(left>0){
            List<Double> taxslab = taxslabs.get(i);
            double taxrate = taxslab.get(1);
            if(taxslab.get(0) == null){
                tax += left*taxrate;
                return tax;
            }
            taxable = Math.min(taxslab.get(0) - previous, left);
            tax += taxable * taxrate;
            left -= taxable;
            previous = taxslab.get(0);
            i++;
        }
        return tax;
    }
    
    public static void main(String[] args) {
        List<List<Double>> taxslabs = new ArrayList<>();
        taxslabs.add(Arrays.asList(10000.0,0.1));
        taxslabs.add(Arrays.asList(20000.0,0.2));
        taxslabs.add(Arrays.asList(30000.0,0.3));
        taxslabs.add(Arrays.asList(null,0.4));
        double tax = calculatetax(taxslabs, 45000);
        System.out.println(tax);
    }
}
