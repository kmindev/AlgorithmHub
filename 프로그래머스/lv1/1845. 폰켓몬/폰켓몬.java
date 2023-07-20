import java.util.*;

class Solution {
    public int solution(int[] nums) {
        // 1. Set에 nums를 저장한다.
        HashSet<Integer> numSet = new HashSet<>();
        
        for(int num : nums) {
            numSet.add(num);
        }
    
        // 2. 선택할 수 있는 수만큼 set에서 선택할 수 있다.
        int choice = nums.length / 2;
        int size = numSet.size();
        
        return size < choice ? size : choice;
    }
}