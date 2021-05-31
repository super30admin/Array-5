class BindRobotInACircle {

    // Time Complexity: O(n)    (where n -> len(instructions))
    // Space Complexity: O(directions) -- O(1)

    public boolean isRobotBounded(String instructions) {
    
        // HashMap to give new directions which we will be facing
        // first -> left and second -> right pair of (left,right) facing direction
        Map<Character, List<Character>> direction = new HashMap<>();
        direction.put('N', Arrays.asList('W','E'));
        direction.put('S', Arrays.asList('E','W'));
        direction.put('E', Arrays.asList('N','S'));
        direction.put('W', Arrays.asList('S','N'));
        
        // HashMap to give change in coordinates after moving in particular direction
        // first -> x and second -> y (x,y) coordinate pair
        Map<Character, List<Integer>> moves = new HashMap<>();
        moves.put('N', Arrays.asList(0,1));
        moves.put('S', Arrays.asList(0,-1));
        moves.put('E', Arrays.asList(1,0));
        moves.put('W', Arrays.asList(-1,0));
        
        int x = 0;
        int y = 0;
        
        char facing = 'N';
        
        for(char c : instructions.toCharArray()){
            if(c == 'L'){
                facing = direction.get(facing).get(0);
            }
            else if(c == 'R'){
                facing = direction.get(facing).get(1);
            }
            else if(c == 'G'){
                x += moves.get(facing).get(0);
                y += moves.get(facing).get(1);
            }
        }
        
        if(x == 0 && y == 0)
            return true;
        
        return facing != 'N';
    }
}