import java.util.Scanner;

public class RobotBoundedInCircleFourIterations {

        // Directions Array Iteration and Four String instructions iterations - Time O(n) and Space O(1)

        public boolean isRobotBounded(String instructions) {

            int n = instructions.length();

            // Directions array - N E S W
            int[][] dirs = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

            int dirIdx = 0;

            // initial position
            int x = 0;
            int y = 0;

            // cycle will be achieved within four movements, if possible
            for(int r = 0; r < 4; r++) {              // O(1) as 4 is constant

                // one iterative coverage of string instructions
                for(int i = 0; i < n; i++) {         // O(n)

                    char c = instructions.charAt(i);

                    // Go straight in whichever facing robot is in
                    if(c == 'G') {

                        //
                        x += dirs[dirIdx][0];
                        y += dirs[dirIdx][1];
                    }

                    // if left, update direction index in array
                    else if(c == 'L') {

                        // N -> W on L
                        dirIdx = (dirIdx + 3) % 4;
                    }

                    // if right, update direction index in array
                    else {

                        // N -> E on R
                        dirIdx = (dirIdx + 1) % 4;
                    }
                }

                // check if cycle formed after each coverage
                if(x == 0 && y == 0) {

                    // cycle
                    return true;
                }
            }
            // no cycle
            return false;
        }

        public static void main(String[] args) {

            RobotBoundedInCircleFourIterations obj = new RobotBoundedInCircleFourIterations();

            Scanner scanner = new Scanner(System.in);

            System.out.println("instructions ");
            String instructions = scanner.nextLine();

            boolean answer = obj.isRobotBounded(instructions);
            System.out.println("if there exists a circle in the plane such that the robot " +
                    "never leaves the circle ? " + answer);

        }

}

/*
Time Complexity = O(n)

Space Complexity = O(1)
*/