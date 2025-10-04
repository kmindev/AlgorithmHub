import java.util.*;

class Solution {
    public int solution(int bridgeLength, int weight, int[] truckWeights) {
        Queue<Integer> bridge = new LinkedList<>();
        for(int i = 0; i < bridgeLength; i++) {
            bridge.offer(0);
        }
  
        int idx = 0;
        int curWeight = 0;
        int sec = 0;
        
        while(idx < truckWeights.length) {
            sec++;
            curWeight -= bridge.poll();
            
            if(curWeight + truckWeights[idx] <= weight) {
                bridge.offer(truckWeights[idx]);
                curWeight += truckWeights[idx];
                idx++;
            } else {
                bridge.offer(0);
            }
        }
        
        return sec + bridgeLength;
    }
    
}