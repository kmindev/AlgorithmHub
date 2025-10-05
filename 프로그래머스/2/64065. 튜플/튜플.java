import java.util.*;

class Solution {
    public int[] solution(String s) {
        List<List<Integer>> tuple = parse(s);
        Set<Integer> set = new LinkedHashSet<>();
        
        for(List<Integer> list : tuple) {
            for(Integer num : list) {
                set.add(num);
            }
        }
        
        return set.stream().mapToInt(i -> i).toArray();
    }
    
    private List<List<Integer>> parse(String s) {
        s = s.substring(1, s.length() - 1);
        List<List<Integer>> tuple = new ArrayList<>();
        int idx = 0;
        StringTokenizer st = new StringTokenizer(s, "{//}//,", true);
        while(st.hasMoreTokens()){
            String token = st.nextToken();
            if(token.equals("{")) {
                continue;
            } else if(token.equals("}")) {
                idx++;
            } else if(token.equals(",")) {
                continue;
            } else { // 숫자
                if(tuple.size() <= idx) {
                    tuple.add(new ArrayList<>());
                }
                List<Integer> t = tuple.get(idx);
                t.add(Integer.parseInt(token));
            }
        }
        
        Collections.sort(tuple, (list1, list2) -> list1.size() - list2.size());
        return tuple;
    } 
}