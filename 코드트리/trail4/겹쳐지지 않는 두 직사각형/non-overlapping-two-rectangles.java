import java.util.Scanner;

public class Main {
    public static int ans = Integer.MIN_VALUE;
    public static int[][] grid;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        for (int x1 = 0; x1 < n; x1++) {
            for (int x2 = x1; x2 < n; x2++) {
                for (int y1 = 0; y1 < m; y1++) {
                    for (int y2 = y1; y2 < m; y2++) {
                        for (int a1 = 0; a1 < n; a1++) {
                            for (int a2 = a1; a2 < n; a2++) {
                                for (int b1 = 0; b1 < m; b1++) {
                                    for (int b2 = b1; b2 < m; b2++) {
                                        if (!is_overlapped(x1, y1, x2, y2, a1, b1, a2, b2)) {
                                            int sum1 = getArea(x1, y1, x2, y2);
                                            int sum2 = getArea(a1, b1, a2, b2);
                                            updateAnswer(x1, y1, x2, y2, a1, b1, a2, b2, sum1 + sum2);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }

    public static boolean is_overlapped(int x1, int y1, int x2, int y2, int a1, int b1, int a2, int b2) {
        return x1 <= a2 && x2 >= a1 && y1 <= b2 && y2 >= b1;
    }

    public static void updateAnswer(int x1, int y1, int x2, int y2, int a1, int b1, int a2, int b2, int val) {
        if (ans < val) {
            // System.out.printf("(%d, %d, %d, %d) (%d, %d, %d, %d), val : %d%n", x1, y1, x2, y2, a1, b1, a2, b2, val);
            ans = val;
        }
    }

    public static int getArea(int x1, int y1, int x2, int y2) {
        int sum = 0;
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                sum += grid[i][j];
            }
        }
        return sum;
    }
}