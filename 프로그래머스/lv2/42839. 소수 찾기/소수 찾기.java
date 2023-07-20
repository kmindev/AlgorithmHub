import java.util.*;

class Solution {
    public int solution(String numbers) {
        int answer = 0;
        // 1. 모든 조합을 찾아 set에 저장한다.
        HashSet<Integer> numSet = new HashSet<>();
        
        recursive("", numbers, numSet);
        System.out.println(numSet);
        
        // 2. 소수를 판별하여 카운트 한다.
        Iterator<Integer> it = numSet.iterator();
        
        while(it.hasNext()) {
            int num = it.next();
            System.out.println(num);
            if(isPrime(num))
                answer++;
        }
        
        return answer;
    }
    
    private void recursive(String ps, String cs, HashSet<Integer> numSet) {
        if(!ps.equals(""))
            numSet.add(Integer.valueOf(ps));
        
        for(int i=0; i<cs.length(); i++) {
            recursive(ps + cs.charAt(i), cs.substring(0, i) + cs.substring(i + 1), numSet);
        }
    }
    
    private boolean isPrime(int num) {
        if(num < 2)
            return false;
        
        int limt = (int)Math.sqrt(num);
        
        for(int i=2; i<=limt; i++) {
            if(num % i == 0)
                return false;
        }
        
        return true;
    }
}