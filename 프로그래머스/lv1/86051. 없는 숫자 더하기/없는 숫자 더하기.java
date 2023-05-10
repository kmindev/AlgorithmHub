class Solution {
    public int solution(int[] numbers) {
    	int answer = 0;
    	boolean[] isCheck = new boolean[10];
    	for(int i=1; i<=9; i++) {
    		for(int num : numbers) {
    			if(num==i) {
    				isCheck[num] = true;
    			}
    		}
    	}
    	
    	for(int i=0; i<isCheck.length; i++) {
    		if(isCheck[i]==false)
    			answer+=i;
    	}

        return answer;
    }
}