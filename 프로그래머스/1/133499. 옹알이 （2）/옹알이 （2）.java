class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        for(String b : babbling) {
            b = b.replace("ayaaya", "0");
            b = b.replace("yeye", "0");
            b = b.replace("woowoo", "0");
            b = b.replace("mama", "0");
            
            b = b.replace("aya", " ");
            b = b.replace("ye", " ");
            b = b.replace("woo", " ");
            b = b.replace("ma", " ");
            
            if(b.trim().equals("")) {
                answer++;
            }
        } 
            
        return answer;
    }
}