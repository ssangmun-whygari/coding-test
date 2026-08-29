import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] queries = new int[n];
        for (int i = 0; i < n; i++) {
            queries[i] = sc.nextInt();
        }
        
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 1; i <= m; i++)
            set.add(i);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int query = queries[i];
            set.remove(query);

            sb.append(set.last() + "\n");
        }
        System.out.print(sb.toString());

    }
}