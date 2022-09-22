class Solution {
    public boolean isRobotBounded(String s) {
     int []curr= {0,0};
        HashMap<Character, int[]>hm= new HashMap<>();
        HashMap<Integer,Character>dirs= new HashMap<>();
        
        int d=0;  
        
        dirs.put(0,'N'); dirs.put(1,'W'); dirs.put(2,'S'); dirs.put(3,'E');
        int []E={0,1}; int []W={0,-1};  int []N={1,0}; int []S={-1,0};
        hm.put('E',E);   hm.put('W',W);   hm.put('N',N);   hm.put('S',S);
        
        for( int i=0;i<s.length();i++){
            
            char c=s.charAt(i);
            if(c=='L'){
                d= (4+(d-1))%4;
                
                
            }else if(c=='R'){
                d= (4+(d+1))%4;
                
                
            }else{
                
                curr[0]=hm.get(dirs.get(d))[0]+curr[0];
                curr[1]=hm.get(dirs.get(d))[1]+curr[1];
                
            }
            
        
        }
        //System.out.println(d+" "+curr[0]+" "+curr[1]);
        
        if(curr[0]==0 && curr[1]==0){ return true;}
        if(d!=0){return true;}
        return false;
    }
}
