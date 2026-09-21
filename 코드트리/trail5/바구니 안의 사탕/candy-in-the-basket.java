import java.util.*;

class Pair implements Comparable<Pair> {
    public int candy;
    public int pos;

    Pair(int candy, int pos) {
        this.candy = candy;
        this.pos = pos;
    }

    @Override
    public int compareTo(Pair other) {
        return Integer.compare(this.pos, other.pos);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        Pair[] arr = new Pair[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Pair(sc.nextInt(), sc.nextInt());
        }
        Arrays.sort(arr);

        int j = 0;
        int sum = arr[0].candy;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            while (j + 1 < n && arr[j + 1].pos - arr[i].pos <= 2 * k) {
                sum += arr[j + 1].candy;
                j++;
            }

            ans = Math.max(ans, sum);

            if (j == n - 1) {
                // 이제 i만 증가시키고서는 최대값이 나올 수 없음
                break;
            }

            sum -= arr[i].candy;
        }

        System.out.print(ans);
    }
}