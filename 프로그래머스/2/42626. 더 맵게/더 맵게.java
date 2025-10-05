import java.util.*;

class Solution {
    public int solution(int[] scovilles, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int scoville : scovilles) {
            pq.offer(scoville);
        }
        
        int answer = 0;
        while(!pq.isEmpty()) {
            int min = pq.poll();
            
            if(min >= K) {
                return answer;
            }
            
            if(pq.isEmpty()) {
                continue;
            }
            
            answer++;
            
            int nextMin = pq.poll();
            int newScoville = min + (nextMin * 2);
            pq.offer(newScoville);
        }
        return -1;
    }
}