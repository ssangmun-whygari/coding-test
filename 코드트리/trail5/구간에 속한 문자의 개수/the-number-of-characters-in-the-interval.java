import java.util.Scanner;

class Tuple {
    public int a, b, c;
    Tuple(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}

public class Main {
    public static Tuple[][] pfSum;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();

        char[][] grid = new char[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            String line = sc.next();
            for (int j = 0; j < M; j++) {
                char ch = line.charAt(j);
                grid[i][j + 1] = ch;
            }
        }

        pfSum = new Tuple[N + 1][M + 1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                pfSum[i][j] = new Tuple(0, 0, 0);
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                Tuple result = pfSum[i][j];
                result.a = pfSum[i - 1][j].a + pfSum[i][j - 1].a - pfSum[i - 1][j - 1].a;
                result.b = pfSum[i - 1][j].b + pfSum[i][j - 1].b - pfSum[i - 1][j - 1].b;
                result.c = pfSum[i - 1][j].c + pfSum[i][j - 1].c - pfSum[i - 1][j - 1].c;
                if (grid[i][j] == 'a') {
                    result.a += 1;
                } else if (grid[i][j] == 'b') {
                    result.b += 1;
                } else { // 'c'
                    result.c += 1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= K; i++) {
            int r1 = sc.nextInt(), c1 = sc.nextInt(), r2 = sc.nextInt(), c2 = sc.nextInt();
            Tuple tuple = getSum(r1, c1, r2, c2);
            sb.append(tuple.a + " " + tuple.b + " " + tuple.c + "\n");
        }
        System.out.print(sb.toString());
    }

    public static Tuple getSum(int r1, int c1, int r2, int c2) {
        int aNum = pfSum[r2][c2].a - pfSum[r1 - 1][c2].a - pfSum[r2][ c1 - 1].a + pfSum[r1 - 1][c1 - 1].a;
        int bNum = pfSum[r2][c2].b - pfSum[r1 - 1][c2].b - pfSum[r2][ c1 - 1].b + pfSum[r1 - 1][c1 - 1].b;
        int cNum = pfSum[r2][c2].c - pfSum[r1 - 1][c2].c - pfSum[r2][ c1 - 1].c + pfSum[r1 - 1][c1 - 1].c;
        return new Tuple(aNum, bNum, cNum);
    }
}