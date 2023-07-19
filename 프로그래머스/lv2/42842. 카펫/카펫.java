class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int size = brown + yellow;
        int max = 0;
         
        for(int i=3; i<=size/2; i++) {
            int x = size /i; // 가로
            int y = i; // 세로
            
            if(x < y) // 가로가 길어야 한다.
                continue;
            
            if((y - 2) * (x - 2) == yellow) {
                answer[0] = x;
                answer[1] = y;
                break;
            }
        }  
        return answer;
    }
}