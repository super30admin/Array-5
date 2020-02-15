


/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
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
		Double tax = helper(0,25000.0, 0.0);
		System.out.println(tax);
	}
	public static Double helper(int index, Double salary, Double limit){
	    
	    Double prec = levels.get(index).get(1);
	    Double taxable = levels.get(index).get(0) == null? null: levels.get(index).get(0) -limit;
	    
	    if(taxable > salary || taxable == null ){
	        return salary * prec ;
	    }
	    
	   // Double tax= taxable*prec; 
	    
	    return taxable*prec + helper(index+1, salary - taxable, levels.get(index).get(0));  
      /// this is also not tailr recursion because we have to come back to calculate and add taxable*prec 
       
	}
	
}
