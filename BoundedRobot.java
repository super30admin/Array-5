class Solution {
    //Time Complexity:O(n)
    //Space Complexity:O(1)

    public boolean isRobotBounded(String instructions) {

       int startDir = 0;    // 0 = north, 1 = east, 2 = south, 3 = west
       int curDir = 0;
        int dist = 0;
        int[] pos = {0,0};
        int n = instructions.length();
       for (int i =0; i < n;i ++){
            char c = instructions.charAt(i);

            if (c == 'R'){
                curDir = (curDir + 1) % 4;
            } else if (c == 'L') {
                curDir--;
                if (curDir < 0)
                curDir = 3;
            } else {
                // we moving
                if (curDir ==0)
                pos[0]++;
                else if (curDir ==1)
                pos[1]++;
                 else if (curDir ==2)
                pos[0]--;
                 else if (curDir ==3)
                pos[1]--;
                
            }
    }
    return startDir != curDir || (pos[0] == 0 && pos[1] ==0);
}
}
