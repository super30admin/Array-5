/*
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(n)
    n = instructions length
* 
* Space Complexity: O(1)
* 
*/

public class RobotCircle {
    int[][] dirs = new int[][] {
            { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 }
    };

    public boolean isRobotBounded(String instructions) {
        int dirIdx = 0;

        int[] currPos = new int[] { 0, 0 };

        for (int index = 0; index < instructions.length(); index++) {
            char command = instructions.charAt(index);

            if (command == 'G') {
                currPos[0] += dirs[dirIdx][0];
                currPos[1] += dirs[dirIdx][1];
            } else {
                if (command == 'R') {
                    dirIdx = (dirIdx + 1) % 4;
                } else {
                    if (dirIdx == 0) {
                        dirIdx = 3;
                    } else {
                        dirIdx--;
                    }
                }
            }
            System.out.println(dirIdx);
        }

        if ((currPos[0] == 0 && currPos[1] == 0) || dirIdx != 0) {
            return true;
        }

        return false;
    }
}