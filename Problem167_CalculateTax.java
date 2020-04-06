//Time Complexity: O(n)
//Recursive Solution
class Solution{
    public static double calculateTax(List<List<Double>> levels, double salary){
        return helper(salary, 0, 0, levels, 0);
    }

    private static double helper(double salary, double tax, double prev, List<List<Double>> levels, int index){
        //base case
        if(salary == 0){
            return tax;
        }
        List<Double> level = levels.get(index);
        double percent = level.get(1);
        if(level.get(0) == null){
            return tax + salary * percent;
        }
        //logic
        double taxableIncome = Math.min(level.get(0) - prev, salary);
        tax += taxableIncome * percent;
        salary -= taxableIncome;
        prev = level.get(0);
        return helper (salary, tax, prev, levels, index+1);

    }
}

//Time Complexity: O(n)
//Iteratative Solution
class Solution{
    public static double calculateTax(List<List<Double>> levels, double salary){
        int i = 0;
        double tax = 0;
        double prev = 0;
        while(salary > 0){
            List<Double> level = levels.get(index);
            double percent = level.get(1);
            if(level.get(0) == null){
                return tax + salary * percent;
            }
            double taxableIncome = Math.min(level.get(0) - prev, salary);
            tax += taxableIncome * percent;
            salary -= taxableIncome;
            prev = level.get(0);
            i++;
        }
        return tax;
    }
}