import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        
        for(int i = 0; i < progresses.length; i++) {
            int remainPercent = 100 - progresses[i]; 
            int completedDay = remainPercent / speeds[i];
            if(remainPercent % speeds[i] != 0) {
                completedDay++;
            }
            
            if(!q.isEmpty() && q.peek() < completedDay) {
                result.add(q.size());
                q.clear();
            }
            
            q.offer(completedDay);
        }
        result.add(q.size());
        
        return result.stream().mapToInt(i -> i).toArray();
    }
}