class Solution {
    public String solution(int[] food) {
        StringBuilder answer = new StringBuilder();
        
        for(int i=1; i<food.length; i++) {
            for(int j=0; j<food[i] / 2; j++) {
                answer.append(i);
            }
        }
        
        int len = answer.length();
        
        answer.append(0);
        
        for(int i=len - 1; i >= 0; i--) {
            answer.append(answer.substring(i, i + 1));
        }
        
        return answer.toString();
    }
}