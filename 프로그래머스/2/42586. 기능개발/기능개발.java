import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < progresses.length; i++) {
            int remainPercent = 100 - progresses[i]; 
            int completedDay = remainPercent / speeds[i];
            if(remainPercent % speeds[i] != 0) {
                completedDay++;
            }
            q.offer(completedDay);
        }
        
        List<Integer> result = new ArrayList<>();
        while(!q.isEmpty()) {
            int cur = q.poll();
            int count = 1;
            while(!q.isEmpty() && q.peek() <= cur) {
                q.poll();
                count++;
            }
            result.add(count);
        }
        
        return result.stream().mapToInt(i -> i).toArray();
    }
}