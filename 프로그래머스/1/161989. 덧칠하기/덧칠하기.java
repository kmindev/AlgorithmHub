class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 1;
        int start = section[0];
        int end = section[0] + m - 1;
        
        for(int s : section) {
            if(s >= start && s <= end ) continue;
            
            start = s;
            end = s + m - 1;
            answer++;
        }
        
        return answer;
    }
}