import java.util.*;

class Segment {
    int start, end;
    Segment (int s, int e) {
        this.start = s;
        this.end = e;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            segments[i] = new Segment(sc.nextInt(), sc.nextInt());
        }

        Arrays.sort(segments, (seg1, seg2) -> {
            return Integer.compare(seg1.end, seg2.end);
        });

        int lastPos = 0;
        int count = 0;
        for (Segment seg : segments) {
            if (lastPos < seg.start) {
                lastPos = seg.end;
                count++;
            }
        }
        System.out.println(count);

    }
}