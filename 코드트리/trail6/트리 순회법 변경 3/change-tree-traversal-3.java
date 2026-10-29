import java.util.*;
import java.io.*;

public class Main {
    public static int[] inOrder;
    public static int[] postOrder;
    public static int[] idx;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        inOrder = new int[n];
        postOrder = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            inOrder[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            postOrder[i] = Integer.parseInt(st.nextToken());
        idx = new int[n]; // post -> in
        int[] inIdx = new int[n + 1];
        for (int i = 0; i < n; i++) {
            inIdx[inOrder[i]] = i;
        }

        for (int i = 0; i < n; i++) {
            idx[i] = inIdx[postOrder[i]];
        }

        recur(0, n - 1, 0, n - 1);
        System.out.print(sb.toString());
    }

    public static void recur(int s1, int e1, int s2, int e2) {
        // s1, e1 : postOrder / s2, e2 : inOrder
        int parent = postOrder[e1];
        sb.append(parent + " ");
        
        int lc_cnt = idx[e1] - s2;
        if (s2 <= idx[e1] - 1) {
            recur(s1, s1 + lc_cnt - 1, s2, idx[e1] - 1); // lc
        }
        if (idx[e1] + 1 <= e2) {
            recur(s1 + lc_cnt, e1 - 1, idx[e1] + 1, e2); // rc
        }
    }
}