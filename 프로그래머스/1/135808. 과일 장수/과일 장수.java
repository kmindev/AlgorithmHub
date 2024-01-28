import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        Arrays.sort(score);
        
        for(int i=0; i<score.length; i+=m) {
            int index = score.length - i - m;
            if(index >= 0 && index < score.length) {
                int min = score[index];
                answer += (min * m);
            }
        }
        
        return answer;
    }
}