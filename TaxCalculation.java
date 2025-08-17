//     import java.util.*;

// // class Solution {

// //     public static void main(String[] args) {
// //         List<List<Double>> levels = new ArrayList<>();

// //         levels.add(Arrays.asList(10000.0, 0.3));
// //         levels.add(Arrays.asList(20000.0, 0.2));
// //         levels.add(Arrays.asList(30000.0, 0.1));
// //         levels.add(Arrays.asList(null, 0.1));

// //         double tax = calculateTax(levels, 45000);
// //         System.out.println(tax);
// //     }

// //     public static double calculateTax(List<List<Double>> levels, double salary) {
// //         double tax = 0.0;
// //         double previousLimit = 0.0;

// //         for (List<Double> bracket : levels) {
// //             Double currentLimit = bracket.get(0); // Can be null
// //             double rate = bracket.get(1);

// //             if (currentLimit == null || salary <= currentLimit) {
// //                 // Salary falls in this bracket
// //                 tax += (salary - previousLimit) * rate;
// //                 break;
// //             } else {
// //                 // Apply full tax for this bracket
// //                 tax += (currentLimit - previousLimit) * rate;
// //                 previousLimit = currentLimit;
// //             }
// //         }

// //         return tax;
// //     }
// // }

// }
