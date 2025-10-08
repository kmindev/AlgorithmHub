import java.util.*;

class Solution {
    public int solution(String s) {
        return solve(s);
    }
    
    private int solve(String s) {
        int answer = Integer.MAX_VALUE;
        for(int unitSize = 1; unitSize <= s.length(); unitSize++) {
            String compressed = compress(s, unitSize);
            int compressedSize = compressed.length();
            answer = Math.min(answer, compressedSize);
        }
        return answer;
    }
    
    private String compress(String s, int unitSize) {
        StringBuilder answer = new StringBuilder();
        String before = "";
        int count = 1;
        for(String token : split(s, unitSize)) {
            if(token.equals(before)) {
                count++;
            } else {
                if(count > 1) {
                    answer.append(count);
                }
                answer.append(before);
                before = token;
                count = 1;
            }
        }
        if(count > 1) {
            answer.append(count);
        }
        answer.append(before);
        return answer.toString();
    }
    
    private List<String> split(String s, int unitSize) {
        List<String> list = new ArrayList<>();
        for(int i = 0; i < s.length(); i+=unitSize) {
            int end = i + unitSize;
            if(end > s.length()) {
                end = s.length();
            }
            list.add(s.substring(i, end));
        } 
        return list;
    }
}