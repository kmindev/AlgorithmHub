class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        int card1Idx = 0;
        int card2Idx = 0;
        
        for(String word : goal) {
            if(card1Idx < cards1.length && cards1[card1Idx].equals(word)) {
                card1Idx++;
                continue;
            }
            
            if(card2Idx < cards2.length && cards2[card2Idx].equals(word)) {
                card2Idx++;
                continue;
            }
            
            answer = "No";
            break;
        }

        return answer;
    }
}