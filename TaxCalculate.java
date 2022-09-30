public class Main {
    public static void main (String[] args) {

	List<List<Double>> levels = new ArrayList<>();
    levels.add( Arrays.asList(10000.0, 0.3) );
    levels.add( Arrays.asList(20000.0, 0.2) );
    levels.add( Arrays.asList(30000.0, 0.1) );
    levels.add( Arrays.asList(null, 0.1) );

    double tax = calculateTax(levels,45000);
    System.out.println(tax);

    }

public static double calculateTax(List<List<Double>> levels, double salary ){
    double tax = 0.0;
    double left = salary;
    double limit = 0.0;
    int i = 0;  // i is used to traverse levels
    
    while(left > 0){
        //check for condition when tax bracket is null initially as if you check later it can be 
        if(levels.get(i).get(0) == null){
            tax = tax + left * levels.get(i).get(1);
            return tax;
        }
        
        double curSlab = levels.get(i).get(0);
        double percentage = levels.get(i).get(1);
        
        double taxableIncome = Math.min(left, curSlab - limit);
        tax = tax + taxableIncome * percentage;
        left = left - (curSlab - limit);
        i++;
        limit = curSlab;
    }
    return tax;
}
}
