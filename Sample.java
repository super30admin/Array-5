//****170.1041.ROBOT BOUNDED IN A CIRCLE*****
//Time complexity: o(n);
//Space complexity:o(1);

class Solution {
    public boolean isRobotBounded(String instructions) {
                                // N     w      S       E
        int[][] dirs=new int[][] {{0,1},{-1,0},{0,-1},{1,0}};
        
        //Initial position of robot
        int x=0; int y=0;
        
        //Robot is pointing in the North Direction
        int i=0;
        
        for(int j=0;j<instructions.length();j++)
        {
            char c=instructions.charAt(j);
            if(c=='L')
            {
                i=(i+1) %4;
            }
            else if(c=='R')
            {
                i=(i+3)%4;
            }
            else
            {
                x+=dirs[i][0];
                y+=dirs[i][1];
            }
        }
        
        return (x==0 && y==0) || i!=0;
        
    }
}

//*****171.2303. TAX RATE
//Time complexity: length of brackets , but at max it would be 4-5 so t.c=constant;
//Space: o(1);
//leetcode runnable:y;
//Any doubts :N;

class Solution {
    public double calculateTax(int[][] brackets, int income) {
        double left=income;
        double limit=0;
        int i=0;
        double tax=0;
        while(left>0)
        {
            int[] bracket=brackets[i];
            double taxable=Math.min(bracket[0]-limit, left);
            int percent=bracket[1];
            tax+=taxable*(percent/100.00);
            
            left-=taxable;
            limit=bracket[0];
            i++ ;
        }
        return tax;
    }
}
