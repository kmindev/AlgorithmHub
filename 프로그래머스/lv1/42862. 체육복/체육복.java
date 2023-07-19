import java.util.Arrays;

public class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        for(int i=0; i<lost.length; i++) {
            for(int j=0; j<reserve.length; j++) {
                if(lost[i] == reserve[j]) {
                    answer++;
                    reserve[j] = -5;
                    lost[i] = -5;
                    break;
                }
            }
        }
        
        
        for(int i=0; i<lost.length; i++) {
            for(int j=0; j<reserve.length; j++) {
                if(lost[i] == reserve[j] - 1 || lost[i] == reserve[j] + 1) {
                    answer++;
                    reserve[j] = -5;
                    break;
                }
            }
        }

        return answer;
    }
}