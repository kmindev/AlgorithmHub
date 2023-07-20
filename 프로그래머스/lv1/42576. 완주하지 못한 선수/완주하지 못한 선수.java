import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class Solution {
    public String solution(String[] participant, String[] completion) {
        // 1. 참가자를 map에 저장한다. 동명이인의 경우 value를 1씩 증가시킨다.
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String part : participant) {
            map.put(part, map.getOrDefault(part, 0) + 1);
        }
        
        // 2. 완주자를 map에 저장, map에 존재할 경우 value를 1 감소해준다.
        for(String comp : completion) {
            map.put(comp, map.getOrDefault(comp, 0) - 1);
        }
        
        // 3. value가 1 이상인 참가자는 완주를 못했기 때문에 return => 한명의 선수만 완주하지 못했기 때문에 가능
        for(String part : map.keySet()) {
            if (map.get(part) > 0)
                return part;
        }
        
        return "";
        
    }
}