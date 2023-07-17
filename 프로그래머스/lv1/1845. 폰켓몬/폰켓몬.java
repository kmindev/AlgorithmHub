import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        int selAmt = nums.length / 2;
        
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }
        
        return set.size() > selAmt ? selAmt : set.size();
    }
}