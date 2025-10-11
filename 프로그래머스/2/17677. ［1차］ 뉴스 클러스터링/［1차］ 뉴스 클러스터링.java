import java.util.*;

class Solution {
    
    public int solution(String str1, String str2) {
        return solve(str1, str2);
    }
    
    private int solve(String str1, String str2) {
        Map<String, Integer> map1 = strParse(str1);
        Map<String, Integer> map2 = strParse(str2);
        
        if(map1.isEmpty() && map2.isEmpty()) {
            return 1 * 65536;
        }
        
        int sumSize = sumSetSize(map1, map2);
        int subSize = subSetSize(map1, map2);
        
        System.out.println("str1: " + str1 + " str2: " + str2);
        System.out.println("map1: " + map1 + " map2: " + map1);
        System.out.println("sum size: " + sumSize + " sub size: " + subSize);
        
        float a = (float) subSize / sumSize;
        return (int) (a * (int) 65536);
    }
    
    private Map<String, Integer> strParse(String str) {
        Map<String, Integer> map = new HashMap<>();
        str = str.toUpperCase();
        for(int i = 0; i < str.length() - 1; i++) {
            String s = str.substring(i, i + 2).replaceAll("[^A-Z]", "");
            if (s.length() < 2) {
                continue;
            }
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        return map;
    }
    
    private int sumSetSize(Map<String, Integer> map1, Map<String, Integer> map2) {
        int size = 0;
        Set<String> keys = new HashSet<>();
        keys.addAll(map1.keySet());
        keys.addAll(map2.keySet());

        for (String key : keys) {
            int count1 = map1.getOrDefault(key, 0);
            int count2 = map2.getOrDefault(key, 0);
            size += Math.max(count1, count2);
        }
        return size;
    }
    
    private int subSetSize(Map<String, Integer> map1, Map<String, Integer> map2) {
        int size = 0;
        for(String key1 : map1.keySet()) {
            if(map2.containsKey(key1)) {
                int min = Math.min(map1.get(key1), map2.get(key1));
                size+= min;
            }
        }
        
        return size;
    }
    
}