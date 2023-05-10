class Solution {
    public int solution(int[] numbers) {
    	int answer = 0;
    	boolean[] isCheck = new boolean[10];
        
    	for(int i=1; i<=9; i++) {
    		for(int num : numbers) {
    			if(num==i) {
    				isCheck[num] = true; // 하나라도 존재하면 true
    			}
    		}
    	}
    	
    	for(int i=1; i<isCheck.length; i++) {
    		if(isCheck[i]==false)
    			answer+=i; // false 인 걸 모두 더한다 
    	}

        return answer;
    }
}