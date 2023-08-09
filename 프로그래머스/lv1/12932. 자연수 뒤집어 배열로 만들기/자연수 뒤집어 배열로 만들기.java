import java.util.*;

class Solution {
    public List<Integer> solution(long n) {
        List<Integer> answer = new ArrayList<>();
        
        while(n > 0) {
            int num = (int) (n % 10);
            answer.add(num);
            n/=10;
        }
        
        System.out.println(answer);
        
        return answer;
    }
}