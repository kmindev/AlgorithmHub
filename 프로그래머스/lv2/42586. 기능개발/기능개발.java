import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        
        for(int i=0; i<progresses.length; i++) {
            double days = (100 - progresses[i]) / (double)speeds[i];
            int day = (int) Math.ceil(days);
            
            int j = i + 1;
            
            for(; j<progresses.length; j++) {
                double jDays = (100 - progresses[j]) / (double)speeds[j];
                int jDay = (int) Math.ceil(jDays);
                
                if(jDay > day)
                    break;
            }
            
            answer.add(j - i);
            i = j - 1;
        }
        
        return answer.stream().mapToInt(i -> i.intValue()).toArray();
    }
}