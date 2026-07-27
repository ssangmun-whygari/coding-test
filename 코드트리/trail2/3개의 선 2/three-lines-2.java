import java.util.Scanner;

public class Main {
    public static int n;
    public static int[] X;
    public static int[] Y;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        X = new int[n];
        Y = new int[n];
        for (int i = 0; i < n; i++) {
            X[i] = sc.nextInt();
            Y[i] = sc.nextInt();
        }

        boolean can = false;
        for (int i = 0; i < 2*n; i++) {
            for (int j = i + 1; j < 2*n; j++) {
                for (int k = j + 1; k < 2*n; k++) {
                    int[][] coords = new int[11][11]; // 0 ~ 10
                    for (int l = 0; l < n; l++) {
                        coords[X[l]][Y[l]] += 1;
                    }
                    draw(i, coords);
                    draw(j, coords);
                    draw(k, coords);
                    
                    int cnt = n;
                    for (int l = 0; l < n; l++) {
                        // X[i], Y[i]
                        if (coords[X[l]][Y[l]] > 1) cnt--;
                    }
                    if (cnt == 0) {
                        // System.out.println("i: " + i + ",j: " + j + ",k: " + k + ",cnt:" + cnt);
                        can = true;
                        break;
                    }
                }
                if (can) break;
            }
            if (can) break;
        }

        System.out.println(can ? 1 : 0);
    }

    public static void draw(int idx, int[][] coords) {
        if (0 <= idx && idx < n) {
            for (int y = 0; y <= 10; y++) {
                coords[X[idx]][y] += 1;
            }
        } else {
            for (int x = 0; x <= 10; x++) {
                coords[x][Y[idx - n]] += 1;
            }
        }
    }
}