import java.util.*;

class Solution {
    
    Map<String, Integer> termMap;
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        init(today, terms, privacies);
        return solve(today, terms, privacies);
    }
    
    private void init(String today, String[] terms, String[] privacies) {
        termMap = new HashMap<>();
    }
    
    private int[] solve(String today, String[] terms, String[] privacies) {
        parseTerms(terms);
        int todayDate = getDate(today);
        
        List<Integer> answer = new ArrayList<>();
        for(int i = 0; i < privacies.length; i++) {
            StringTokenizer st = new StringTokenizer(privacies[i], " ");
            int date = getDate(st.nextToken());
            String type = st.nextToken();
            
            int term = termMap.get(type);
            
            if(date + (term  * 28) <= todayDate) {
                answer.add(i + 1);
            }
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
    
    private int getDate(String s) {
        StringTokenizer st = new StringTokenizer(s, ".");
        int year = Integer.parseInt(st.nextToken());
        int month = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());
        return (year * 12 * 28) + (month * 28) + day;
    }
    
    private void parseTerms(String[] terms) {
        for(String term : terms) {
            String[] token = term.split(" ");
            termMap.put(token[0], Integer.parseInt(token[1]));
        }
    }
}