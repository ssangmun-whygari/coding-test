import java.util.*;

class Bomb implements Comparable<Bomb> {
    public int score;
    public int time;

    Bomb(int score, int time) {
        this.score = score;
        this.time = time;
    }

    @Override
    public int compareTo(Bomb other) {
        if (this.time != other.time) {
            return Integer.compare(other.time, this.time);
        } else {
            return Integer.compare(other.score, this.score);
        }
    }

    @Override
    public String toString() {
        return "Bomb[점수:" + score + ",시간:" + time + "]";
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Bomb> bombs = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            bombs.add(new Bomb(sc.nextInt(), sc.nextInt()));
        }

        PriorityQueue<Bomb> select = new PriorityQueue<>((b1, b2) -> {
            return Integer.compare(b2.score, b1.score);
        });

        int score = 0;
        for (int t = 10000; t >= 1; t--) {
            // t 이상인 bomb을 select에 넣는다.
            while (!bombs.isEmpty() && bombs.peek().time >= t) {
                select.add(bombs.poll());
            }

            // 가장 점수가 높은 폭탄을 고른다.
            if (!select.isEmpty()) {
                Bomb selected = select.poll();
                score += selected.score;
                // System.out.println(t + "초에 " + selected + "를 고름");
            }
        }
        System.out.print(score);
    }
}