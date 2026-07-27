import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        int ans = -1;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    int result = check(arr[i], arr[j], arr[k]);
                    ans = Math.max(result, ans);
                }
            }
        }

        System.out.println(ans);
    }

    public static int check(int a, int b, int c) {
        int n = Math.max(Math.max(a, b), c);
        int[] aa = convert(a, n);
        int[] bb = convert(b, n);
        int[] cc = convert(c, n);

        for (int i = 0; i < n; i++) {
            if (aa[i] + bb[i] + cc[i] >= 10) {
                return -1;
            }
        }
        return a + b + c;
    }

    // 1의 자리부터 자리수를 채운다.
    public static int[] convert(int a, int n) {
        String s = a + " ";
        int[] result = new int[n];
        for (int i = 0; i < s.length(); i++) {
            result[i] = Character.getNumericValue(s.charAt(s.length() - 1 - i));
        }
        return result;
    }
}