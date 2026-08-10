import java.util.*;

public class Main {
    public static int N;
    public static int K;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        K = sc.nextInt();
        N = sc.nextInt();

        recur(new ArrayList<Integer>());
    }

    public static void recur(List<Integer> list) {
        if (list.size() == N) {
            for (int num : list) {
                System.out.print(num + " ");
            }
            System.out.print("\n");
            return;
        }

        for (int i = 1; i <= K; i++) {
            list.add(i);
            recur(list);
            list.remove(list.size() - 1);
        }
    }
}