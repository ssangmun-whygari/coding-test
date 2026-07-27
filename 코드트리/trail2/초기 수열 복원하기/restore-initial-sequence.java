import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] injup = new int[N - 1];
        for (int i = 0; i < N - 1; i++) {
            injup[i] = sc.nextInt();
        }

        for (int i = 1; i < injup[0]; i++) {

            boolean[] punch = new boolean [N + 1]; // 1 ~ N
            List<Integer> sequence = new ArrayList<>();
            int last = i;
            punch[last] = true;
            sequence.add(last);

            for (int j = 0; j < N - 1; j++) {
                // injup[j] - last
                last = injup[j] - last;
                if (last > 0 && last <= N) {
                    punch[last] = true;
                    sequence.add(last);
                } else {
                    break;
                }
            }

            boolean allIncludes = true;
            for (int j = 1; j <= N; j++) {
                if (!punch[j]) {
                    allIncludes = false;
                    break;
                }
            }

            if (allIncludes) {
                for (int num : sequence) {
                    System.out.print(num + " ");
                }
                break;
            }

        }

    }
}