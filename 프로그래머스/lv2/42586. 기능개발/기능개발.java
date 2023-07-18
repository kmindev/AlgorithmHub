import java.util.*;

class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        int[] days = new int[progresses.length];
        Deque<Integer> q = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        
        for(int i=0; i<progresses.length; i++) {
            int p = 100 - progresses[i]; // 남은 작업량
            int compDay = p % speeds[i] > 0 ? p/speeds[i] + 1 : p/speeds[i]; // 배포 가능 일
            days[i] = compDay;
        }
        
        q.offer(days[0]);
        
        for(int i=1; i<days.length; i++) {
            if(q.peek() >= days[i]) {
                q.offer(days[i]);
            } else {
                result.add(q.size());
                q.clear();
                q.offer(days[i]);
            }
        }
        result.add(q.size());
     
        return result;
    }
}