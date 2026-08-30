import java.util.*;

class Dot implements Comparable<Dot> {
    public int x, y;
    Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Dot other) {
        int myDist = this.x + this.y;
        int otherDist = other.x + other.y;
        if (myDist != otherDist) {
            return Integer.compare(myDist, otherDist);
        } else if (this.x != other.x) {
            return Integer.compare(this.x, this.y);
        } else {
            return Integer.compare(this.y, this.y);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] points = new int[n][2];
        for (int i = 0; i < n; i++) {
            points[i][0] = sc.nextInt();
            points[i][1] = sc.nextInt();
        }

        PriorityQueue<Dot> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.add(new Dot(points[i][0], points[i][1]));
        }

        for (int i = 0; i < m; i++) {
            Dot dot = pq.poll();
            pq.add(new Dot(dot.x + 2, dot.y + 2));
        }
        Dot ans = pq.poll();
        System.out.print(ans.x + " " + ans.y);
    }
}