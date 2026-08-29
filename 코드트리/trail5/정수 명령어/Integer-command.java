import java.util.*;
public class Main {
    public static TreeSet<Integer> set = new TreeSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int tc = 0; tc < t; tc++) {
            int n = sc.nextInt();
            set.clear();
            for (int i = 0; i < n; i++) {
                char cmd = sc.next().charAt(0);
                int num = sc.nextInt();

                if ('I' == cmd) {
                    set.add(num);
                } else if ('D' == cmd) {
                    if (set.isEmpty()) continue;
                    if (num == 1) {
                        set.remove(set.last());
                    } else if (num == -1) {
                        set.remove(set.first());
                    }
                }
            }
            if (!set.isEmpty()) {
                System.out.println(set.last() + " " + set.first());
            } else {
                System.out.println("EMPTY");
            }
        }
    }
}