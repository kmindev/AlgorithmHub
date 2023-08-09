import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        Arrays.fill(answer, "");
        String[] arr1Binary = new String[n];
        String[] arr2Binary = new String[n];
        
        for(int i=0; i<arr1.length; i++) {
            arr1Binary[i] = String.format("%0" + n + "d", Long.parseLong(Integer.toBinaryString(arr1[i])));
            arr2Binary[i] = String.format("%0" + n + "d", Long.parseLong(Integer.toBinaryString(arr2[i])));
        }
      
        for(int i=0; i<arr1Binary.length; i++) {
            for(int j=0; j<arr1Binary[i].length(); j++) {
                if(arr1Binary[i].charAt(j) == '1' || arr2Binary[i].charAt(j) == '1') {
                    answer[i] += "#";
                } else {
                    answer[i] += " ";
                }
            }
        }
       
        return answer;
    }
}