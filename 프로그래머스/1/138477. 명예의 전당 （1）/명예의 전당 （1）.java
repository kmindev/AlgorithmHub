import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        
        for(int i=0; i<score.length; i++) {
            int[] copyScore = Arrays.copyOf(score, i + 1);
            
            answer[i] = getMinScore(copyScore, k); 
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