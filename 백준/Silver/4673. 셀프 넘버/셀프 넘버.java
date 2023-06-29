public class Main {
    public static void main(String[] args) {
        boolean[] selfNumCheck = new boolean[10001];

        for (int i = 1; i < 10001; i++) {
            int sum = i;
            int num = i;
            while (num > 0) {
                sum += (num % 10);
                num /= 10;
            }
            if (sum < 10001) 
                selfNumCheck[sum] = true;
            
        }

        for (int i = 1; i < selfNumCheck.length; i++) {
            if (!selfNumCheck[i])
                System.out.println(i);
        }
    }
}