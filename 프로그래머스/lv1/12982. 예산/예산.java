import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int answer = 0;
        int index = 0;
        
        while(budget > 0) {
            budget -= d[answer];
            
            answer++;
            
            if(answer > d.length - 1)
                break;
        }
        
        if(budget < 0)
            answer--;        
    
        return answer;
    }
}