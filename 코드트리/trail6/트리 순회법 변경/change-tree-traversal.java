import java.util.*;
import java.io.*;

public class Main {
    public static int[] preOrder;
    public static StringBuilder sb = new StringBuilder();
    public static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        preOrder = new int[n];
        for (int i = 0; i < n; i++) {
            preOrder[i] = Integer.parseInt(br.readLine());
        }
        recur(0, n - 1);

        System.out.print(sb.toString());
    }

    public static void recur(int s, int e) {
        if (s == e) {
            sb.append(preOrder[s] + "\n");
            return;
        }
        if (s > e) {
            return;
        }

        int cur = s;
        while (cur + 1 < n && preOrder[cur + 1] < preOrder[s]) {
            cur++;
        }
        recur(s + 1, cur);
        recur(cur + 1, e);
        sb.append(preOrder[s] + "\n"); // parent
    }
}