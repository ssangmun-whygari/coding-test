import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TreeSet<Integer> set = new TreeSet<Integer>();
        
        for (int i = 0; i < n; i++) {
            String cmd = sc.next();
            if ("add".equals(cmd)) {
                int x = sc.nextInt();
                set.add(x);
            } else if ("remove".equals(cmd)) {
                int x = sc.nextInt();
                set.remove(x);
            } else if ("find".equals(cmd)) {
                int x = sc.nextInt();
                System.out.println(set.contains(x) ? "true" : "false");
            } else if ("lower_bound".equals(cmd)) {
                int x = sc.nextInt();
                Integer lb = set.ceiling(x);
                System.out.println(lb == null ? "None" : lb);
            } else if ("upper_bound".equals(cmd)) {
                int x = sc.nextInt();
                Integer ub = set.higher(x);
                System.out.println(ub == null ? "None" : ub);
            } else if ("largest".equals(cmd)) {
                System.out.println(set.isEmpty() ? "None" : set.last());
            } else if ("smallest".equals(cmd)) {
                System.out.println(set.isEmpty() ? "None" : set.first());
            }
        }
    }
}