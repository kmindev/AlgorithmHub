class Solution {
    public long solution(int price, int money, int count) {
        long sum = 0;
        
        for(int i=1; i<count+1; i++) { 
        	sum += price * i;   // 총 금액 구하기
        }
        
        if(money - sum >= 0) // 돈이 안부족하면
        	return 0;
        
        return sum - money; // 부족한 금액
    }
}