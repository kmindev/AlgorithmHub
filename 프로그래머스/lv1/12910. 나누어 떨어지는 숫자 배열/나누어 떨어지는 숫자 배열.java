import java.util.*;

class Solution {
    public List solution(int[] arr, int divisor) {
        List<Integer> answer = new ArrayList<>();
        for(int num : arr) {
            if(num % divisor == 0) 
                answer.add(num);
        }
        Collections.sort(answer);
        
        if(answer.size() == 0)
            answer.add(-1);
        
        return answer;
    }
}