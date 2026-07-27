import java.util.*;

class Record {
    public int x, y, select;
    public Record(int x, int y, int select) {
        this.x = x;
        this.y = y;
        this.select = select;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Record[] records = new Record[N];
        for (int i = 0; i < N; i++) {
            records[i] = new Record(sc.nextInt(), sc.nextInt(), sc.nextInt());
        }

        int bestScore = 0;
        for (int i = 1; i <= 3; i++) { // 조약돌을 넣는 컵 선택
            boolean[] cups = new boolean[4]; // 1 ~ 3
            cups[i] = true;
            int score = 0;
            for (int j = 0; j < N; j++) { // 각각의 케이스에 대해 점수 계산
                swap(records[j].x, records[j].y, cups);
                if (cups[records[j].select]) score++;
            }
            if (score > bestScore) {
                bestScore = score;
            }
        }

        System.out.println(bestScore);
    }

    public static void swap(int x, int y, boolean[] cups) {
        boolean temp = cups[x];
        cups[x] = cups[y];
        cups[y] = temp;
    }
}