// time & space: O(1)
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tax {
    public static double calculateTax(List<List<Double>> taxSlabs, double salary) {
        double left = salary, taxableAmount = 0, prevLimit = 0, tax = 0;
        int i=0;
        while(left>0) {
            List<Double> taxSlab = taxSlabs.get(i);
            if(taxSlab.get(0) == null) {
                tax += taxSlab.get(1)*left;
                break;
            }
            taxableAmount = Math.min(taxSlab.get(0)-prevLimit, left);
            prevLimit = taxSlab.get(0);
            tax += taxSlab.get(1) * taxableAmount;
            left -= taxableAmount;
            i++;
        }
        return tax;
    }
    public static void main(String[] args) {
        List<List<Double>> slabs = new ArrayList<>();
        slabs.add(Arrays.asList(10000.0,0.1));
        slabs.add(Arrays.asList(20000.0,0.2));
        slabs.add(Arrays.asList(30000.0,0.3));
        slabs.add(Arrays.asList(null,0.4));
        System.out.println(calculateTax(slabs, 25000)); //4500.0
        System.out.println(calculateTax(slabs, 45000)); // 12000.0
    }
}
