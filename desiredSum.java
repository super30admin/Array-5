/*
Problem:

Given a list of integers and desiredSum, find the threshold value such that if we replace all the values in the input list which are 
greater than threshold value with the threshold value then the sum of the list should be equal to the desired sum. 
Testcase 1 in = [2,1,5] desiredSum = 6 output = 3
Testcase 2 in = [2,1,5] desiredSum = 2 output = 0.67
Testcase 3 in = [2,1,5] desiredSum = 4 output = 1.5
Testcase 4 in = [2,1,5] desiredSum = 1 output = 0.33
*/


/*
TC: O(n log n)
SC: O(1)

Think of this problem as a work distribution problem. Assume that we have to distribute 'desiredSum' amount of work among n (nums.length) workers.
The average load each worker will take will be desiredSum / n. Sort the worker capacities in increasing order.
If a worker is not able to perform average load, the rest (average - worker load) needs to be distributed among other workers.
*/
public class Main {
    
    private static double getThreshold(int nums[], int desiredSum) {
        int n = nums.length;
        // Initialized to the average value. Multiply by 1.0 to make it double.
        double threshold = desiredSum * 1.0 / n;
        
        Arrays.sort(nums);
        for (int i = 0; i < n; ++i) {
            if (nums[i] < threshold) {
                threshold += (threshold - nums[i]) / (n - i - 1);
            } else {
                break;
            }
        }
        
        return threshold;
    }
    
    public static void main(String[] args) {
        int nums[] = new int[]{2,1,5};
        int desiredSum = 6;
        System.out.println(getThreshold(nums, desiredSum));
    }
}