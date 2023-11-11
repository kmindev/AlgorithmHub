class Solution {
    public String solution(String my_string, int n) {
        StringBuilder answer = new StringBuilder();
        
        for(char ch : my_string.toCharArray()) {
            answer.append((ch + "").repeat(n)); 
        }
        
        return answer.toString();
    }
}