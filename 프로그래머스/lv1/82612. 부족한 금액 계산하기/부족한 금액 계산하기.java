class Solution {
    public long solution(int price, int money, int count) {
        long sum = 0;
        
        int prc = price;
        		
        for(int i=0; i<count; i++) {
        	
        	sum+=price; 
        	price+=prc;
        }
        
        if(money - sum > 0)
        	return 0;
        
        return sum - money;
    }
}