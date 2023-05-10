class Solution {
    public int solution(int[][] sizes) {
    	for(int i=0; i<sizes.length; i++) {
    		int a = sizes[i][0];
    		int b = sizes[i][1];
    		
    		if(a>b) { // [작은값, 큰값] 정리
    			int temp = sizes[i][0];
    			sizes[i][0] = sizes[i][1];
    			sizes[i][1] = temp;
    		}
    	}
    	
    	int xMax = 0;
    	int yMax = 0; 
    	
    	for(int i=0; i<sizes.length; i++) {
    		if(xMax < sizes[i][0])
    			xMax = sizes[i][0]; // 작은값 중 가장 큰 값
    		
    		if(yMax < sizes[i][1])
    			yMax = sizes[i][1]; // 큰값 중 가장 큰 값
    	}
    	
    	

        return xMax * yMax;
    }
}