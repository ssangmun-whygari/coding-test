import java.util.*;

public class Main {
    // 북, 동, 남, 서(시계 방향)
    // 오른쪽으로 90도 회전은 시계 방향
    public static int[] dx = new int[] {0, 1, 0, -1}; 
    public static int[] dy = new int[] {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        int dirNum = 0; // 북쪽
        int x = 0; int y = 0;
        for (char cmd : input.toCharArray()) {
            if (cmd == 'L') {
                dirNum = (dirNum - 1 + 4) % 4;
            } else if (cmd == 'R') {
                dirNum = (dirNum + 1) % 4;
            } else if (cmd == 'F') {
                x = x + dx[dirNum];
                y = y + dy[dirNum];
            }
        }
        System.out.println(x + " " + y);
    }
}