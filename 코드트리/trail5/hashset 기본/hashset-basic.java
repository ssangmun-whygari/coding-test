import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String cmd = sc.next();
            int x = sc.nextInt();
            if ("add".equals(cmd)) {
                set.add(x);
            } else if ("remove".equals(cmd)) {
                set.remove(x);
            } else if ("find".equals(cmd)) {
                if (set.contains(x)) {
                    System.out.println("true");
                } else {
                    System.out.println("false");
                }
            }
        }
    }
}