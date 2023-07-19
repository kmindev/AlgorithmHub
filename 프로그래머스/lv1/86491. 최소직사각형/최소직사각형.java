import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int xMax = Integer.MIN_VALUE;
        int yMax = Integer.MIN_VALUE;
    	for(int i=0; i<sizes.length; i++) {
            if(sizes[i][0] < sizes[i][1]) {
                int temp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;
            }
            
            if(xMax < sizes[i][0])
                xMax = sizes[i][0];
            
            if(yMax < sizes[i][1])
                yMax = sizes[i][1];
        }
        
        return xMax * yMax;
    }
}