import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();

        int v = 1;
        int t = 0;
        int s = 0;

        while (++t > 0) {
            s += v;

            int s0 = 0;
            // 올려도 괜찮은가?
            // 다음초에는 올리고 그 다음부터는 1m/s까지 감속시킨다고 가정
            // v = 2라면 3 + 2 + 1
            // v = 3이라면 4 + 3 + 2 + 1
            for (int i = 1; i <= v + 1; i++) {
                s0 += i;
            }
            // 올리는 게 안된다면 유지해도 괜찮은가?
            int s1 = s0 - (v + 1);

            if (a - s >= s0) {
                v++;
            } else if (a - s >= s1) {
                // 속도 유지
            } else {
                v--;
            }

            if (a - s == 0) {
                break;
            }
        }

        System.out.println(t);
    }
}