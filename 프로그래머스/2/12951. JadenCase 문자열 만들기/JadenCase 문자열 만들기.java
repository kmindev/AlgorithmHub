import java.util.*;
class Solution {
    public String solution(String s) {
        s = s.toLowerCase(); //처음부터 다 소문자로 바꿔버리기
        StringTokenizer st = new StringTokenizer(s, " ", true);
        StringBuilder sb = new StringBuilder();

        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            if(token.equals(" ")) {
                sb.append(token);
            } else {
                sb.append(token.substring(0, 1).toUpperCase() + token.substring(1));
            }
        }

        return sb.toString();
    }
}