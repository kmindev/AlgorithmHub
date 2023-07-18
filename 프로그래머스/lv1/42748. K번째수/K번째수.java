import java.util.*;

class Solution {
    public List<Integer> solution(int[] array, int[][] commands) {
        ArrayList<Integer> answer = new ArrayList<>();
    
        for(int[] arr : commands) {
            int i = arr[0];
            int j = arr[1];
            int k = arr[2];
            ArrayList<Integer> list = new ArrayList<>();
            
            for(int x=i; x<=j; x++) {
                list.add(array[x - 1]);
            }
            
            Collections.sort(list);
            
            System.out.println(list);
            answer.add(list.get(k - 1));
        }
        
        return answer;
    }
}