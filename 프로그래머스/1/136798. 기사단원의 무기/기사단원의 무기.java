import java.util.*;

class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        for (int i=1; i<=number; i++) {
            int primeCount = primeNumberCount(i);
            
            if(primeCount > limit) {
                answer += power;
            } else {
                answer += primeCount;
            }
        }
        return answer;
    }
    
    private int primeNumberCount(int num) {
        int count = 0;
        
        for(int i=1; i<=num / 2; i++) {
            if(num % i == 0) count++;
        }
        
        return ++count;
    }
}