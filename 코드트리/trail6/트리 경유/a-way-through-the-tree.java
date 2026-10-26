import java.util.*;

public class Main {
    public static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();

        arr = new int[n + 1];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            int query = sc.nextInt();
            int num = process(query);
            if (num == 0) {
                arr[query] = 1; // 1을 색칠
            }
            sb.append(num + "\n");
        }
        System.out.print(sb.toString());
    }

    public static int process(int q) { // 도달가능하면 0을 반환한다.
        int x = 0;
        while (q > 1) {
            if (arr[q] == 1) {
                x = q;
            }
            q /= 2;
        }
        return x;
    }
}