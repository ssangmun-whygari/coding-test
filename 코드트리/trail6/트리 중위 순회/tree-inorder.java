import java.util.*;
public class Main {
    public static int[] arr;
    public static List<Integer>[] treeShape;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = (1 << k) - 1;
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        treeShape = new ArrayList[k];
        for (int level = 0; level < k; level++) {
            treeShape[level] = new ArrayList<Integer>();
        }

        recur(0, 0, n - 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            if (!treeShape[i].isEmpty()) {
                for (int node : treeShape[i]) {
                    sb.append(node);
                    sb.append(' ');
                }
                sb.append('\n');
            }
        }
        System.out.print(sb.toString());
    }


    public static void recur(int level, int start, int end) {
        if (start == end) {
            treeShape[level].add(arr[start]);
            return;
        }

        int mid = getMid(start, end);
        treeShape[level].add(arr[mid]);

        // start ~ mid - 1
        recur(level + 1, start, mid - 1);
        // mid + 1 ~ end
        recur(level + 1, mid + 1, end);
    }

    
    public static int getMid(int start, int end) {
        if (start == end) {
            return 1;
        }
        int n = end - start + 1; // n >= 2
        int x = log2(n); // x >= 1
        n = Math.min(n, square(2, x) + square(2, x - 1) - 1);

        // m = 왼쪽 서브트리의 개수
        int m = (square(2, x) / 2) + (n - square(2, x));

        return start + m;
    }

    public static int square(int n, int k) {
        int temp = n;
        while (k-- > 0) {
            n = n * temp;
        }
        return n;
    }

    public static int log2(int n) {
        int x = 0;
        while (n > 1) {
            n /= 2;
            x++;
        }
        return x;
    }
}