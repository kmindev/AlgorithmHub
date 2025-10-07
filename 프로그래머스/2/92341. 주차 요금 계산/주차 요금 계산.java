import java.util.*;
import java.util.stream.*;
import java.time.*;

class Solution {
    
    int DEFAULT_TIME;
    int DEFAULT_PRICE;
    int UNIT_TIME;
    int UNIT_PRICE;
    
    Map<String, LocalTime> inMap;
    Map<String, Integer> minuteMap;
    Map<String, Integer> chargeMap;
    
    public int[] solution(int[] fees, String[] records) {
        init(fees, records);
        return solve(fees, records);
    }
    
    private int betweenToMinute(LocalTime inTime, LocalTime outTime) {
        return (int) Duration.between(inTime, outTime).toMinutes(); // out - in
    }
    
    private int[] solve(int[] fees, String[] records) {
        for(String record : records) {
            Info info = Info.parse(record);
            String carNum = info.carNum;
            if(info.inOrOut.equals("OUT")) {
                // 누적 주차 시간
                LocalTime inTime = inMap.get(carNum);
                LocalTime outTime = info.time;
                int minute = betweenToMinute(inTime, outTime);
                minuteMap.put(carNum, minuteMap.getOrDefault(carNum, 0) + minute);
                inMap.remove(carNum);
            } else if(info.inOrOut.equals("IN")) {
                inMap.put(carNum, info.time);
            }
        }
        
        // 나가지 않은 차량
        for(String carNum : inMap.keySet()) {
            LocalTime inTime = inMap.get(carNum);
            LocalTime outTime = LocalTime.of(23, 59);
            int minute = betweenToMinute(inTime, outTime);
            minuteMap.put(carNum, minuteMap.getOrDefault(carNum, 0) + minute);
        }
        
        // 요금 계산
        System.out.println(minuteMap);
        for(String carNum : minuteMap.keySet()) {
            int minute = minuteMap.get(carNum);
            int charge = caculateCharge(minute);
            chargeMap.put(carNum, charge);
        }
        
        // 차량 번호 기준 정렬
        List<String> orderedCarNum = chargeMap.keySet().stream()
            .sorted()
            .collect(Collectors.toList());
        int[] answer = new int[orderedCarNum.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = chargeMap.get(orderedCarNum.get(i));
        }
        return answer;
    }
    
    private int caculateCharge(int minute) {
        if(DEFAULT_TIME >= minute) {
            return DEFAULT_PRICE;
        }
        
        double overTimePerUnitTime = (minute - DEFAULT_TIME) / (double) UNIT_TIME;
        int overMinute = (int) Math.ceil(overTimePerUnitTime);
        return DEFAULT_PRICE + overMinute * UNIT_PRICE;
    }
    
    private void init(int[] fees, String[] records) {
        DEFAULT_TIME = fees[0];
        DEFAULT_PRICE = fees[1];
        UNIT_TIME = fees[2];
        UNIT_PRICE = fees[3];
        
        inMap = new HashMap<>();
        minuteMap = new HashMap<>();
        chargeMap = new HashMap<>();
    }
    
    static class Info {
        String carNum;
        String inOrOut;
        LocalTime time;
        
        public static Info parse(String record) {
            Info info = new Info();
            String[] recordTokens = record.split(" ");
            info.time = parseTime(recordTokens[0]);
            info.carNum = recordTokens[1];
            info.inOrOut = recordTokens[2];
            return info;
        }
        
        private static LocalTime parseTime(String input) {
            String[] tokens = input.split(":");
            int h = Integer.parseInt(tokens[0]);
            int m =  Integer.parseInt(tokens[1]);
            return LocalTime.of(h, m);
        }  
        
        @Override
        public String toString() {
            return String.format("carNum: %s, inOrOut: %s, time: %s", carNum, inOrOut, time); 
        }
    }
}