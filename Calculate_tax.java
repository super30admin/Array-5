class CFG{
    public static void main(String[] args){
        List<List<Double>> levels = new ArrayList<>():
        levels.add(Arrays.asList(10000.0, 0.3);
        levels.add(Arrays.asList(20000.0, 0.2);
        levels.add(Arrays.asList(30000.0, 0.1);
        levels.add(Arrays.asList(null, 0.1);
                   
        doule tax = calulateTax(levels, 45000);
       }
                  
    public static double calculateTax(List<List<double>> levels, double salary){
        return helper(salary, 0, 0, levels, 0);
    }
        
    private static double helper(double salary, double prev, double tax, List<List<Double>> levels, int index){
        
      //base
      if(salary < 0) return tax;
      List<Double> le = levels.get(index);
      double percent = le.get(1);
      if(le.get(0) == null return tax + percent * salary;
      double currentTaxable = Math.min(le.get(0) - prev, salary);
      tax += currentTaxable * percent;
      salary -= currentTaxable;
      prev = le.get(0);
      return helper(salary, prev, tax, levels, index+1);
     
   }
  }
         
  //TC: O(n)
  //SC: O(n)
                   
