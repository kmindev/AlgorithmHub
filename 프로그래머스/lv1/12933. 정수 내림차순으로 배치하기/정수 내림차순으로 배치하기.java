import java.util.*;

class Solution {
    public long solution(long n) {
        String[] sArr = (n + "").split("");
        
        Arrays.sort(sArr);
        
        StringBuilder sb = new StringBuilder();
        
        for(String s : sArr) {
            sb.append(s);
        }
        
        return Long.parseLong(sb.reverse().toString());
    }
}