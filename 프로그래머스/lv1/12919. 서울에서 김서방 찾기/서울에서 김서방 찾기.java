class Solution {
    public String solution(String[] seoul) {
        int index = 0;
        for(; index<seoul.length; index++) {
            if(seoul[index].equals("Kim"))
                break;
        }
        
        return "김서방은 " + index + "에 있다";
    }
}