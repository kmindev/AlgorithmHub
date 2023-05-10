import java.util.StringTokenizer;

class Solution {
   public String solution(String polynomial) {
        StringTokenizer st1 = new StringTokenizer(polynomial, "+");
        int x = 0; // x의 계수
        int constant = 0; // 상수항

        while (st1.hasMoreTokens()) {
            String token = st1.nextToken();
            token = token.trim();

            if(token.contains("x")) { // 1차항
                // x가 포함되어 있으면 token.length가 1보다 큼
                x += token.length() > 1 ? Integer.parseInt(token.replace("x", "")) : 1;
            } else { // 상수항
                constant += Integer.parseInt(token);
            }
        }

        StringBuilder sb = new StringBuilder();

        if(x == 1) {    // x의 계수가 1
            if(constant > 0)
                sb.append("x + " + constant);
            else if(constant == 0)
                sb.append("x");
        } else if(x > 1) {   // x의 계수가 2 이상
            if(constant > 0)
                sb.append(x + "x + " + constant);
            else if(constant == 0)
                sb.append(x + "x");
        } else {              // x의 계수가 0 이하
            if(constant > 0)
                sb.append(""+constant);
        }
        return sb.toString();
    }
}