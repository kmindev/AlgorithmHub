class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        long pNum = Long.parseLong(p);
        long num = 0;
        for(int i=0; i<t.length() - p.length() + 1; i++) {
            num = Long.parseLong(t.substring(i, i + p.length()));
            if(num <= pNum) {
                answer++;
            }
        }
        return answer;
    }
}