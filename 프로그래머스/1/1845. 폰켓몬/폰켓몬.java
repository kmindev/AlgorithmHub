import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int choiceCount = nums.length / 2;
        Set<Integer> set = new HashSet<>();
        
        for(Integer num : nums) {
            set.add(num);
        }
        
        return set.size() > choiceCount ? choiceCount : set.size();
    }
}