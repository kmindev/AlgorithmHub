import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int[] nums) {
        int selAmt = nums.length / 2;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        
        
        return map.size() > selAmt ? selAmt : map.size();
    }
}