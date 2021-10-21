
    
/*
    1041. Robot Bounded In Circle
    TC - O(n);
    SC - O(n);
*/
class BindRobotinaCircleSol1 {
    public boolean isRobotBounded(String instructions) {
        if(instructions == null || instructions.length() == 0) return true ;
        
        char dir = 'N';
        int x = 0 , y = 0 ;

        for ( int i = 0 ; i < instructions.length(); i ++){
        if (instructions.charAt(i) == 'G'){
            if(dir == 'N')
                y ++ ;
            else if(dir == 'E')
                x ++ ;
            else if(dir == 'S')
                y -- ;
            else 
                x -- ;
            }else if ( instructions.charAt(i) == 'L'){
                if(dir == 'N')
                dir = 'W';
                else if (dir == 'S')
                dir ='E' ;
                else if (dir == 'W')
                dir = 'S' ;
                else dir = 'N';
            }else {
                if (dir == 'N')
                dir = 'E';
                else if (dir == 'E')
                dir = 'S' ;
                else if ( dir == 'S')
                dir = 'W';
                else 
                dir = 'N';
            }
        }
    
        return ((x ==0 && y == 0) || (dir != 'N'));
}
}