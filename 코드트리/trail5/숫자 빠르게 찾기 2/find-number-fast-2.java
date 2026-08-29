import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int[] queries = new int[m];
        for (int i = 0; i < m; i++)
            queries[i] = sc.nextInt();
        
        TreeSet<Integer> set = new TreeSet<>();
        for (int i : arr)
            set.add(i);
        StringBuilder sb = new StringBuilder();
        for (int i : queries) {
            Integer lb = set.ceiling(i);
            if (lb == null) {
                sb.append(-1);
            } else {
                sb.append(lb);
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}