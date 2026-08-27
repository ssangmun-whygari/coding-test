import java.util.*;
public class Main {
    public static Set[] sets;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[k];
        int[] b = new int[k];
        for (int i = 0; i < k; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }

        // pos[i] = j -> i번 자리에 j번 사람이 앉아있다.
        int[] pos = new int[n + 1]; // 1 ~ n;
        for (int i = 1; i <= n; i++)
            pos[i] = i;
        
        // sets[i] : i번 사람이 앉은 자리 집합
        sets = new Set[n + 1];
        for (int i = 1; i <= n; i++) {
            sets[i] = new HashSet<Integer>();
            sets[i].add(i);
        }

        int round = 3;
        while (round-- > 0) {
            doRound(pos, a, b);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(sets[i].size() + "\n");
        }
        System.out.print(sb.toString());
    }

    public static void doRound(int[] pos, int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            // a[i]번과 b[i]번 자리에 앉은 사람을 바꾼다.
            int temp = pos[a[i]];
            pos[a[i]] = pos[b[i]];
            pos[b[i]] = temp;

            // System.out.println("a[i] : " + a[i] + ",b[i] : " + b[i] + ",pos[a[i]] : " + pos[a[i]] + ",pos[b[i]] : " + pos[b[i]]);
            // System.out.println(Arrays.toString(pos));

            // a[i] : 자리, pos[a[i]] : 사람
            sets[pos[a[i]]].add(a[i]);
            sets[pos[b[i]]].add(b[i]);
        }
    }
}