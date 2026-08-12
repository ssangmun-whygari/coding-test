import java.util.*;

public class Main {
    public static int N;
    public static int M;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        recur(new ArrayList<Integer>(), 0);

        System.out.println(sb);
    }

    public static void recur(List<Integer> seq, int selected) {
        if (seq.size() == M) {
            for (int num : seq) {
                sb.append(num + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = selected + 1; i <= N; i++) {
            seq.add(i);
            recur(seq, i);
            seq.remove(seq.size() - 1);
        }
    }
}