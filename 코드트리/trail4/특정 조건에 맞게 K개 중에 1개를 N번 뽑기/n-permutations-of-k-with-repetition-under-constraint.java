import java.util.*;

public class Main {
    public static int k;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        int n = sc.nextInt();
        
        int[] seq = new int[n];
        recur(seq, 0, n);

        System.out.println(sb.toString());
    }

    public static void recur(int[] seq, int end, int n) {
        if (end == n) {
            for (int i = 0; i < seq.length; i++) {
                sb.append(seq[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= k; i++) {
            if (end >= 2 && i == seq[end - 1] && i == seq[end - 2]) {
                continue;
            }
            seq[end] = i;
            recur(seq, end + 1, n);
        }
    }
}