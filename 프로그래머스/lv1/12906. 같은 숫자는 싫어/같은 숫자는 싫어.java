import java.util.*;

public class Solution {
    public Deque<Integer> solution(int []arr) {
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(arr[0]);
        for(int i=1; i<arr.length; i++) {
            if(q.getLast() != arr[i]) {
                q.offer(arr[i]);
            }
        }
        
        return q;
    }
}