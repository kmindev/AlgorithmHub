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
        DateInfo todayDate = DateInfo.from(today);
        
        List<Integer> answer = new ArrayList<>();
        for(int i = 0; i < privacies.length; i++) {
            StringTokenizer st = new StringTokenizer(privacies[i], " ");
            DateInfo date = DateInfo.from(st.nextToken());
            String type = st.nextToken();
            
            int term = termMap.get(type);
            if(date.isExpired(todayDate, term)) {
                answer.add(i + 1);
            }
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
    
    private void parseTerms(String[] terms) {
        for(String term : terms) {
            String[] token = term.split(" ");
            termMap.put(token[0], Integer.parseInt(token[1]));
        }
    }
    
    static class DateInfo {
        int year;
        int month;
        int day;
        
        public static DateInfo from(String s) {
            StringTokenizer st = new StringTokenizer(s, ".");
            DateInfo dateInfo = new DateInfo();
            dateInfo.year = Integer.parseInt(st.nextToken());
            dateInfo.month = Integer.parseInt(st.nextToken());
            dateInfo.day = Integer.parseInt(st.nextToken());
            return dateInfo;
        }
        
        public boolean isExpired(DateInfo todayDate, int term) {
            int expiredYear = this.year;
            int expiredMonth = this.month + term;
            int expiredDay = this.day - 1;
            
            if(expiredDay == 0) {
                expiredDay = 28;
                expiredMonth -= 1;
            }
            
            if(expiredMonth > 12) {
                expiredYear += (expiredMonth - 1) / 12;
                expiredMonth = (expiredMonth - 1) % 12 + 1;
            }
            return isExpired(todayDate, expiredYear, expiredMonth, expiredDay);
        }
        
        private boolean isExpired(DateInfo todayDate, int expiredYear, int expiredMonth, int expiredDay) {
            if(expiredYear < todayDate.year) {
                return true;
            } else if(expiredYear == todayDate.year) {
                if(expiredMonth < todayDate.month) {
                    return true;
                } else if(expiredMonth == todayDate.month) {
                    if(expiredDay < todayDate.day) {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
    }
    
}