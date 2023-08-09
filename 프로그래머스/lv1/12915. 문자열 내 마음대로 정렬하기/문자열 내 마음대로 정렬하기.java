class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = {};
        int minIndex = 0;
        
        for(int i=0; i<strings.length; i++) {
            for(int j=i; j<strings.length; j++) {
                if(strings[j].charAt(n) < strings[i].charAt(n)) {
                    String temp = strings[i];
                    strings[i] = strings[j];
                    strings[j] = temp;
                }
                
                if(strings[j].charAt(n) == strings[i].charAt(n)) {
                    if(strings[i].compareTo(strings[j]) > 0) {
                        String temp = strings[i];
                        strings[i] = strings[j];
                        strings[j] = temp;
                    }
                }
            }
        }
        return strings;
    }
}