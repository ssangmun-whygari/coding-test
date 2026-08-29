import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] queries = new int[n];
        for (int i = 0; i < n; i++) {
            queries[i] = sc.nextInt();
        }
        
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);

        Integer closest = Integer.MAX_VALUE;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int query = queries[i];

            set.add(query);

            Integer left = set.lower(query);
            Integer right = set.higher(query);

            if (left != null) {
                closest = Math.min(query - left, closest);
            }
            if (right != null) {
                closest = Math.min(right - query, closest);
            }
            sb.append(closest + "\n");
        }

        System.out.print(sb.toString());
    }
}