import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int Q = sc.nextInt();
        int[] points = new int[N];
        for (int i = 0; i < N; i++) {
            points[i] = sc.nextInt();
        }
        int[][] query = new int[Q][2];
        for (int i = 0; i < Q; i++) {
            query[i][0] = sc.nextInt();
            query[i][1] = sc.nextInt();
        }

        TreeSet<Integer> set = new TreeSet<>();
        for (int p : points) {
            set.add(p);
        }

        Map<Integer, Integer> map = new HashMap<>();
        Iterator<Integer> it = set.iterator();
        int x = 0;
        while (it.hasNext()) {
            map.put(it.next(), x++);
        }

        StringBuilder sb = new StringBuilder();
        for (int[] q : query) {
            int i = map.get(q[0]);
            int j = map.get(q[1]);
            sb.append(j - i + 1 + "\n");
        }
        System.out.print(sb.toString());
    }
}