import java.util.*;

class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        for (int i=1; i<=number; i++) {
            int divisorCount = divisorNumberCount(i);
            
            if(divisorCount > limit) {
                answer += power;
            } else {
                answer += divisorCount;
            }
        }
        return answer;
    }
    
    private int divisorNumberCount(int num) {
        int count = 0;
        
        for(int i=1; i<=num / 2; i++) {
            if(num % i == 0) count++;
        }
        
        return ++count;
    }
}