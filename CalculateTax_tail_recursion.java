


import java.util.*;
import java.lang.*;
public class Main
{
    public static List<List<Double>> levels;
	public static void main(String[] args) {
		levels  = new ArrayList<>();
		levels.add(Arrays.asList(10000.0, 0.3));
		levels.add(Arrays.asList(20000.0, 0.2));
		levels.add(Arrays.asList(30000.0, 0.1));
		levels.add(Arrays.asList(null, 0.1));
		Double tax = helper(0,25000.0, 0.0,0.0);
		System.out.println(tax);
	}
	public static Double helper(int index, Double salary, Double limit,Double currtax){
	    
	    Double prec = levels.get(index).get(1);
	    Double taxable = levels.get(index).get(0) == null? null: levels.get(index).get(0) -limit;
	    
	    if(taxable > salary || taxable == null ){
	        return salary * prec  + currtax;
	    }
	    
	    Double tax= taxable*prec+currtax; 
	    
	    return   helper(index+1, salary - taxable, levels.get(index).get(0), tax);
       
	}
	
}
