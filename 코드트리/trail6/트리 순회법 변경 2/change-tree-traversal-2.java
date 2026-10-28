import java.util.*;
import java.io.*;

public class Main {
    public static int[] idx;
    public static int[] preOrder;
    public static int[] inOrder;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        idx = new int[n];

        preOrder = new int[n];
        inOrder = new int[n];
        int[] inIdx = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            preOrder[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            inOrder[i] = Integer.parseInt(st.nextToken());
            inIdx[inOrder[i]] = i;
        }
        for (int i = 0; i < n; i++) {
            idx[i] = inIdx[preOrder[i]];
        }

        recur(0, n - 1, 0, n - 1);
        System.out.print(sb.toString());
    }

    public static void recur(int s_pre, int e_pre, int s_in, int e_in) {
        int lc_num = idx[s_pre] - s_in;
        if (s_in <= idx[s_pre] - 1) {
            recur(s_pre + 1, s_pre + lc_num, s_in, idx[s_pre] - 1); // lc
        }
        if (idx[s_pre] + 1 <= e_in) {
            recur(s_pre + lc_num + 1, e_pre, idx[s_pre] + 1, e_in); // rc
        }
        sb.append(preOrder[s_pre] + " ");
    }

}