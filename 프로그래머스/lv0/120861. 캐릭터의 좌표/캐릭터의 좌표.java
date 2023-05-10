class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = {0, 0};

        for(String input : keyinput) {
            if(input.equals("left") && answer[0] > -board[0]/2 ) {
                answer[0]--;
            } else if (input.equals("down") && answer[1] > -board[1]/2 ) {
                answer[1]--;
            } else if (input.equals("up") && answer[1] < board[1]/2 ) {
                answer[1]++;
            } else if(input.equals("right") && answer[0] < board[0]/2 ){
                answer[0]++;
            }
        }
        return answer;
    }
}