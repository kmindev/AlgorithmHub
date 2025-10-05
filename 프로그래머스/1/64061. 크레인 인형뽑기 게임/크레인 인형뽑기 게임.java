import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        
        for(int move : moves) {
            int sit = move - 1;
            int doll = catchDoll(board, sit);
            if(doll == 0) {
                continue;
            }
            
            if(!stack.isEmpty() && stack.peek() == doll) {
                answer += 2;
                stack.pop();
                continue;
            }
            stack.push(doll);
        }
        
        return answer;
    }
    
    private int catchDoll(int[][] board, int sit) {
        int doll = 0;
        for(int i = 0; i < board.length; i++) {
            if(board[i][sit] != 0) {
                doll = board[i][sit];
                board[i][sit] = 0;
                break;
            }
        }
        return doll;
    }
    
}
