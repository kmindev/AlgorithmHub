class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        int count = 0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == ' ') {
                count = 0;
                answer.append(" ");
            } else if(count % 2 == 0) {
                answer.append(s.substring(i, i+1).toUpperCase());
                count++;
            } else if(count % 2 != 0) {
                answer.append(s.substring(i, i+1).toLowerCase());
                count++;
            }
        
        }
        
        return answer.toString();
    }
}