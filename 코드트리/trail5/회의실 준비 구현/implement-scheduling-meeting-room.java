import java.util.*;

class Segment implements Comparable<Segment> {
    public int start, end;

    Segment(int s, int e) {
        this.start = s;
        this.end = e;
    }

    @Override
    public int compareTo(Segment other) {
        return Integer.compare(this.end, other.end);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        PriorityQueue<Segment> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.add(new Segment(sc.nextInt(), sc.nextInt()));
        }
        
        int cnt = 0;
        int lastEnd = 0;
        // 시작시간이 lastEnd 이상인 회의를 배정할 수 있다.
        while (!pq.isEmpty()) {
            Segment seg = pq.poll();
            if (lastEnd <= seg.start) {
                cnt++;
                lastEnd = seg.end;
            }
        }
        System.out.print(cnt);
    }
}