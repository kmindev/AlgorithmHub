class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        
        for(int i=0; i<s.length(); i++) {
            int index = -1;
            for(int j=0; j<i; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    index = i - j;
                }
            }
            answer[i] = index;
        }
        return answer;
    }
}