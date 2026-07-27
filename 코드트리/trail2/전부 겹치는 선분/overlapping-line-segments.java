import java.util.Scanner;

class Segment {
    public int low = 0;
    public int high = 0;
    public boolean isValid = true;

    public Segment(int low, int high) {
        this.low = low;
        this.high = high;
    }

    public String toString() {
        return "Segment[" + low + "," + high + "]";
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Segment[] segments = new Segment[N];

        for (int i = 0; i < N; i++) {
            int low = sc.nextInt();
            int high = sc.nextInt();
            segments[i] = new Segment(low, high);
        }

        Segment cur = segments[0];
        for (int i = 1; i < N; i++) {
            if (cur == null) break;
            Segment next = intersect(cur, segments[i]);
            cur = next;
        }

        if (cur != null) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    public static Segment intersect(Segment s1, Segment s2) {
        if (s1.high < s2.low || s2.high < s1.low) {
            return null;
        } else {
            int low = Math.max(s1.low, s2.low);
            int high = Math.min(s1.high, s2.high);
            return new Segment(low, high);
        }
    }
}