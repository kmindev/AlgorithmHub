import java.util.*;

class Solution {
    
    public int[] solution(int N, int[] stages) {
        return solve(N, stages);
    }
    
    private int[] solve(int N, int[] stages) {
        int[] count = new int[N + 2];
        for(int stage : stages) {
            count[stage]++;
        }
        
        float[] failRate = new float[N + 1];
        int remaining = stages.length;
        
        for(int i = 1; i <= N; i++) {
            if(remaining == 0) {
                failRate[i] = 0f;
            } else {
                failRate[i] = (float) count[i] / remaining;
            }
            remaining -= count[i];
        }
        
        Integer[] answer = new Integer[N];
        for(int i = 0; i < N; i++) {
            answer[i] = i + 1;
        }
        
        Arrays.sort(answer, (o1, o2) -> {
            if(failRate[o1] == failRate[o2]) {
                return o1 - o2;
            }
            return Float.compare(failRate[o2], failRate[o1]);
        });
        
        return Arrays.stream(answer).mapToInt(i -> i).toArray();
    }
}