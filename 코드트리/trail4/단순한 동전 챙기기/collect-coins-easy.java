import java.util.*;

class Pos implements Comparable<Pos> {
    int x, y, priority;
    Pos(int x, int y, int priority) {
        this.x = x;
        this.y = y;
        this.priority = priority;
    }

    public int compareTo(Pos other) {
        return Integer.compare(this.priority, other.priority);
    }
}

public class Main {
    public static List<Pos> posList;
    public static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        posList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String row = sc.next();
            for (int j = 0; j < N; j++) {
                char ch = row.charAt(j);
                if (ch == 'S') {
                    posList.add(new Pos(i, j, 0));
                } else if (ch == 'E') {
                    posList.add(new Pos(i, j, Integer.MAX_VALUE));
                } else if (Character.isDigit(ch)) {
                    posList.add(new Pos(i, j, Character.getNumericValue(ch)));
                }
            }
        }

        Collections.sort(posList);
        recur(0, 0, 0);

        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }

    public static void recur(int distSum, int selected, int cnt) {
        if (cnt == 3) {
            distSum += getDist(posList.get(selected), posList.get(posList.size() - 1));
            ans = Math.min(ans, distSum);
            return;
        }

        for (int i = selected + 1; i < posList.size() - 1; i++) {
            // dist 구하기
            // posList.get(selected), posList.get(i)
            int dist = getDist(posList.get(selected), posList.get(i));
            recur(distSum + dist, i, cnt + 1);
        }
    }

    public static int getDist(Pos p1, Pos p2) {
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    }
}