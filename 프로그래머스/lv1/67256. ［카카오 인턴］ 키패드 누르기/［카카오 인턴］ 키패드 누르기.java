class Solution {
    Location left;
    Location right;
    Location numPos;

    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();

        // 1. 왼손 오른손 위치 초기화
        left = new Location(3, 0);
        right = new Location(3, 2);

        for (int num : numbers) {
            // 2. 숫자를 누를 손가락 정하기
            if (num == 0)
                numPos = new Location(3, 1);
            else
                numPos = new Location((num - 1) / 3, (num - 1) % 3);

            String finger = numPos.getFinger(hand);

            // 3. 정해진 손가락을 answer에 담고 손가락 위치 위동
            answer.append(finger);

            if (finger.equals("L"))
                left = numPos;
            else
                right = numPos;
        }

        return answer.toString();
    }

    class Location {
        int row;
        int col;

        public Location(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public String getFinger(String hand) {
            String finger = hand.equals("left") ? "L" : "R";

            if (this.col == 0)
                finger = "L";
            else if (this.col == 2)
                finger = "R";
            else {
                int leftDis = left.getDistance(this);
                int rightDis = right.getDistance(this);

                if (leftDis > rightDis)
                    finger = "R";
                else if (rightDis > leftDis)
                    finger = "L";
            }

            return finger;
        }

        private int getDistance(Location location) {
            return Math.abs(this.row - location.row) + Math.abs(this.col - location.col);
        }
    }
}