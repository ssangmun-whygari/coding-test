import java.util.*;

class Pos {
    public int x, y;
    Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static List<Pos> dots = new ArrayList<>();
    public static int N;
    public static int M;
    public static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        for (int i = 0; i < N; i++) {
            dots.add(new Pos(sc.nextInt(), sc.nextInt()));
        }

        List<Integer> selected = new ArrayList<>();
        recur(-1, selected);

        System.out.println(ans);
    }

    public static void recur(int i, List<Integer> selected) {
        if (selected.size() == M) {
            ans = Math.min(ans, calcMaxDist(selected));
            return;
        }

        for (int k = i + 1; k < N; k++) {
            selected.add(k);
            recur(k, selected);
            selected.remove(selected.size() - 1);
        }
    }

    public static int calcMaxDist(List<Integer> selected) {
        int maxDist = 0;
        for (int i = 0; i < selected.size(); i++) {
            for (int j = i + 1; j < selected.size(); j++) {
                int dx = dots.get(selected.get(i)).x - dots.get(selected.get(j)).x;
                int dy = dots.get(selected.get(i)).y - dots.get(selected.get(j)).y;
                int squareOfDist = dx*dx + dy*dy;
                maxDist = Math.max(squareOfDist, maxDist);
            }
        }
        return maxDist;
    }

}