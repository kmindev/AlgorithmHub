import java.util.StringTokenizer;

class Solution {
    public String solution(String s) {
        s = s.toLowerCase();
        StringTokenizer st = new StringTokenizer(s, " ", true);
        StringBuilder sb = new StringBuilder();
        while (st.hasMoreTokens()) {
            String word = st.nextToken();
            if (word.equals(" ")) {
                sb.append(word);
            } else {
                sb.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1));
            }
        }
        return sb.toString();
    }
}