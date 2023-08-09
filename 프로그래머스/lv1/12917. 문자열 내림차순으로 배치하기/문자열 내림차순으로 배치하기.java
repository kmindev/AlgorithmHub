import java.util.*;

class Solution {
    public String solution(String s) {
        String[] sArr = s.split("");
        Arrays.sort(sArr);
        StringBuilder answer = new StringBuilder();
        for(int i=sArr.length-1; i>=0; i--) {
            answer.append(sArr[i]);
        }
        return answer.toString();
    }
}