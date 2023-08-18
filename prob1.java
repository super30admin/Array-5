// Time Complexity : O(n)
// Space Complexity : O(1)


class Solution {
    public boolean isRobotBounded(String instructions) {
        int x = 0, y = 0;
        char dir = 'N';
        for(char ch : instructions.toCharArray()){
            if(ch == 'G'){
                switch(dir){
                    case 'N':   y++; break;
                    case 'E':   x++; break;
                    case 'W':   x--; break;
                    case 'S':   y--; break;          
                }
            }
            else if( ch == 'L'){
                switch(dir){
                    case 'N':   dir = 'W'; break;
                    case 'E':   dir = 'N'; break;
                    case 'W':   dir = 'S'; break;
                    case 'S':   dir = 'E'; break;       
                } 
            }
            else{
                switch(dir){
                    case 'N':   dir = 'E'; break;
                    case 'E':   dir = 'S'; break;
                    case 'W':   dir = 'N'; break;
                    case 'S':   dir = 'W'; break;          
                }
            }
        }

        if(x == 0 && y == 0) return true;

        if(dir == 'N') return false;
        
        return true;
    }

    
}


