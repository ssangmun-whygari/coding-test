import java.util.Scanner;
public class Main {
    public static int[] first;
    public static int[] second;
    public static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        first = new int[n];
        second = new int[n];
        for(int i = 0; i < n; i++){
            first[i] = sc.nextInt();
            second[i] = sc.nextInt();
        }
        
        // (가위, 바위, 보), (가위, 보, 바위), (바위, 가위, 보)...
        int ans = 0;
        ans = Math.max(ans, dual(1, 2, 3));
        ans = Math.max(ans, dual(1, 3, 2));
        ans = Math.max(ans, dual(2, 1, 3));
        ans = Math.max(ans, dual(2, 3, 1));
        ans = Math.max(ans, dual(3, 1, 2));
        ans = Math.max(ans, dual(3, 2, 1));

        System.out.println(ans);
    }

    public static int dual(int r, int s, int p) {
        // r : 주먹, s : 가위, p : 보
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (first[i] == r && second[i] == s || first[i] == s && second[i] == p || first[i] == p && second[i] == r)  {
                cnt++;
            }
        }
        return cnt;
    }
}