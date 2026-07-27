import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[N][N];
        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++)
                arr[i][j] = sc.nextInt();
        
        int cntCoin = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 2; j++) {
                // arr[i][j], arr[i][j + 1], arr[i][j + 2]
                for (int k = 0; k < N; k++) {
                    for (int l = 0; l < N - 2; l++) {
                        // 같은 행에 있다면 겹칠 가능성이 있다.
                        if (i == k && Math.abs(j - l) < 3) continue;
                        int cand = arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[k][l] + arr[k][l+1] + arr[k][l+2];
                        // if (cand > cntCoin) {
                        //     System.out.println("i : " + i + ", j : " + j + ", k : " + k + ", l : " + l);
                        // }
                        cntCoin = Math.max(cntCoin, cand);
                    }
                }
            }
        }
        System.out.println(cntCoin);
    }
}