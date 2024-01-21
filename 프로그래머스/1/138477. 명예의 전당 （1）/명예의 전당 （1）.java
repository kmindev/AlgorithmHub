import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
         PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0; i<score.length; i++) {
            pq.add(score[i]);
            
            if(pq.size() > k) {
                pq.poll();
            }
            
            answer[i] = pq.peek();
        }
        
        return answer;
    }
    
    private int getMinScore(int[] copyScore, int k) {
        Arrays.sort(copyScore);
        
        if(copyScore.length < k) {
            return copyScore[0];
        } else {
            return copyScore[copyScore.length - k];
        }

    }
    
    
}