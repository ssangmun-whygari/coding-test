import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] x = new int[N];
        char[] dir = new char[N];
        for (int i = 0; i < N; i++) {
            x[i] = sc.nextInt();
            dir[i] = sc.next().charAt(0);
        }
        
        int[] rooms = new int[2000]; // 0 ~ 2000까지의 구간(OFFSET = 1000)

        int now = 1000;
        for (int i = 0; i < N; i++) {
            // [now, now + dx)
            if (dir[i] == 'R') {
                for (int j = 0; j < x[i]; j++) {
                    rooms[now++] += 1;
                }
            } else if (dir[i] == 'L') {
                for (int j = 0; j < x[i]; j++) {
                    rooms[--now] += 1;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i] >= 2) 
                answer++;
        }
        System.out.println(answer);
    }
}