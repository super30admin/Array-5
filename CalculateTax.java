import java.util.Arrays;
import java.util.List;

// "static void main" must be defined in a public class.
public class Main {

    //Time Complexity: 0(1); because there will be a finite no. of tax slabs
    //Space Complexity: 0(1)

    public static double calculateTax(List<List<Double>> levels, double salary){
        int i = 0;  //to iterate over different tax slabs 1 by 1
        double limit = 0;   //to calculate the taxable income
        double left = salary;   //to calculate the taxable income from the salary left after being taxed for a tax slab
        double tax = 0; //total tax

        while(left > 0){
            List<Double> taxSlab = levels.get(i);   //getting the tax slabs 1 by 1
            double percentage = taxSlab.get(1); //getting the percentage levied on that taxslab

            if(taxSlab.get(0) == null){ //if I reach the final taxslab, then I calculate the tax based on what's left of my salary
                tax = tax + left * percentage;
                break;  //then I break
            }

            double TaxableIncome = Math.min(taxSlab.get(0) - limit, left);//taxable income for this taxslab. initially limit is 0. So i get the current tax slab and subtract it from limit. Based on that, my tax will be calculated. I have taken min between this and left because there might come a point when my leftover salary will be less than the range of the taxable income. For eg: 25000. 1st, 10k will be taxed by 10%. left will be 15k. THen another 10k will be taxed by 20%. Left will be 5k. So 5k < 10k, hence my 30 % will be levied on 5k rather than 10k
            tax = tax + TaxableIncome * percentage; //calculating tax
            limit = taxSlab.get(0); //updating my limit to current limit
            left = left - TaxableIncome;    //getting my left over salary that is to be taxed
            i++;    //increasing the pointer in my list
        }

        return tax; //returning total tax
    }

    public static void main(String[] args) {

        List<List<Double>> levels = new ArrayList<>();

        levels.add( Arrays.asList(10000.0, 0.1) );
        levels.add( Arrays.asList(20000.0, 0.2) );
        levels.add( Arrays.asList(30000.0, 0.3) );
        levels.add( Arrays.asList(null, 0.4) );
        double tax = calculateTax(levels,25000);

        System.out.println(tax);
    }
}