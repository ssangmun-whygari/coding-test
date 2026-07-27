import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] tiles = new int[100 * 1000 * 2];

        int cnt = 100 * 1000;
        for (int i = 0; i < N; i++) {
            int dist = sc.nextInt();
            char dir = sc.next().charAt(0);

            if (dir == 'R') {
                while (true) {
                    if (dist <= 1) {
                        tiles[cnt] = 1; // 1은 검은색
                        break;
                    }
                    dist--;
                    tiles[cnt++] = 1;
                }
            } else {
                while (true) {
                    if (dist <= 1) {
                        tiles[cnt] = -1; // -1은 흰색
                        break;
                    }
                    dist--;
                    tiles[cnt--] = -1;
                }
            }
        }

        int cntW = 0; // 흰색 타일의 개수
        int cntB = 0; // 검은색 타일의 개수

        for (int i = 0; i < tiles.length; i++) {
            if (tiles[i] == -1) {
                cntW++;
            } else if (tiles[i] == 1) {
                cntB++;
            }
        }
        System.out.println(cntW + " " + cntB);
    }
}