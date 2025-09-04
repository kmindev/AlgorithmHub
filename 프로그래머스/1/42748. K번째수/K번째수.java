import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length]; 
        for(int l = 0; l < commands.length; l++) {
            
            List<Integer> list = new ArrayList<>();
            
            int i = commands[l][0];
            int j = commands[l][1];
            int k = commands[l][2];
            
            for(; i<=j; i++) {
                list.add(array[i - 1]);
            }
            Collections.sort(list);
            answer[l] = list.get(k - 1);
        }
        
        return answer;
    }
}