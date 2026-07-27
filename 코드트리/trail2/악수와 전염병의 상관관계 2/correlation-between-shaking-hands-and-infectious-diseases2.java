import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int P = sc.nextInt();
        int T = sc.nextInt();

        // 1. 어떤 t초에 악수를 한 개발자 번호 목록
        int[][] records = new int[250 + 1][2];
        // 2. 개발자들의 감염 상태
        boolean[] developers = new boolean[N + 1]; // 1 ~ N
        developers[P] = true; // 처음에 걸려있는 개발자의 번호
        // 3. 감염시킬 수 있는 최대 횟수
        int[] ability = new int[N + 1]; // 1 ~ N
        Arrays.fill(ability, K);

        for (int i = 0; i < T; i++) {
            int t = sc.nextInt();
            records[t][0] = sc.nextInt();
            records[t][1] = sc.nextInt();
        }

        for (int i = 0; i <= 250; i++) {
            int devA = records[i][0];
            int devB = records[i][1];
            if (devA == 0 || devB == 0) {
                continue;
            }
            if (developers[devA] == true && developers[devB] == true) {
                ability[devA] = ability[devA] > 0 ? ability[devA] - 1 : 0;
                ability[devB] = ability[devB] > 0 ? ability[devB] - 1 : 0;
            } else if (developers[devA] == false && developers[devB] == false) {
                continue;
            } else if (developers[devA] == true) {
                if (ability[devA] > 0) {
                    ability[devA]--;
                    developers[devB] = true;
                }
            } else {
                if (ability[devB] > 0) {
                    ability[devB]--;
                    developers[devA] = true;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < developers.length; i++) {
            if (developers[i] == true) {
                sb.append("1");
            } else {
                sb.append("0");
            }
        }
        System.out.println(sb.toString());
    }
}