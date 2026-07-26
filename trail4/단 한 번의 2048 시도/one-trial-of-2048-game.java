import java.util.Scanner;

public class Main {
    public static int[][] grid;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        grid = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        char dir = sc.next().charAt(0);

        if (dir == 'L') {
            shiftLeft();
        } else if (dir == 'U') {
            rotateCCW();
            shiftLeft();
            for (int i = 0; i < 3; i++)
                rotateCCW();
        } else if (dir == 'R') {
            rotateCCW(); rotateCCW();
            shiftLeft();
            rotateCCW(); rotateCCW();
        } else if (dir == 'D') {
            for (int i = 0; i < 3; i++)
                rotateCCW();
            shiftLeft();
            rotateCCW();
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void shiftLeft() {
        int[][] temp = new int[4][4];
        for (int i = 0; i < 4; i++) {
            int tempIdx = 0;
            int lastVal = 0;
            int valNum = 0;
            for (int j = 0; j < 4; j++) {
                if (grid[i][j] == 0) continue;
                if (grid[i][j] == lastVal) {
                    if (valNum >= 1) {
                        temp[i][tempIdx - 1] = grid[i][j] * 2;
                        valNum = 0;
                    } else { // valNum == 0
                        temp[i][tempIdx++] = grid[i][j];
                        valNum = 1;
                    }
                } else {
                    temp[i][tempIdx++] = grid[i][j];
                    lastVal = grid[i][j];
                    valNum = 1;
                }
            }
        }
        grid = temp;
    }

    public static void rotateCCW() {
        int[][] temp = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                temp[3 - j][i] = grid[i][j];
            }
        }
        grid = temp;
    }
}