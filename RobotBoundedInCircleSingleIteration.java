import java.util.Scanner;

public class RobotBoundedInCircleSingleIteration {

        // Directions Array Iteration and Single String instructions iterations - Time O(n) and Space O(1)

        public boolean isRobotBounded(String instructions) {

            int n = instructions.length();

            // Directions array - N E S W
            int[][] dirs = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

            int dirIdx = 0;

            // initial position
            int x = 0;
            int y = 0;

            // single iterative coverage of string instructions
            for(int i = 0; i < n; i++) {         // O(n)

                char c = instructions.charAt(i);

                // Go straight in whichever facing robot is in
                if(c == 'G') {

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

            // if robot reached initial position or if not facing north - cycle occurs
            // only north-facing robot nullifies possibility of cycle
            return (x == 0 && y == 0) || (dirIdx != 0);
        }

        public static void main(String[] args) {

            RobotBoundedInCircleSingleIteration obj = new RobotBoundedInCircleSingleIteration();
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

exactly o(n), not O(4n)

Space Complexity = O(1)
*/