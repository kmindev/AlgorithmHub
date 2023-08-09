import java.util.*;

class Solution {
    public List solution(int[] arr) {
        List<Integer> answer = new ArrayList<>();
        
        int min = Integer.MAX_VALUE;
        
        for(int i=0; i<arr.length; i++) {
            if(min > arr[i]) {
                min = arr[i];
            }
        }
        
        for(int num : arr) {
            if(num != min) {
                answer.add(num);
            }
        }
        
        if(answer.size() == 0)
            answer.add(-1);
        
        return answer;
    }
}