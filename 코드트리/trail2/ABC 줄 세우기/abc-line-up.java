import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] arr = new char[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next().charAt(0);
        }
        
        int cnt = 0;
        char temp = 0;

        // B C D A E

        // B C A D E
        // B A C D E
        // A B C D E

        // B C A D E
        // B A C D E
        // A B C D E

        // System.out.println((char)('A' + 1));


        for (int j = 0; j < n; j++) {
            // 처음에는 'A'를 찾으려고 함
            for (int i = j; i < n; i++) {
                if (arr[i] == (char)('A' + j)) {
                    cnt += (i - j);
                    // i를 j쪽으로 이동시키면서 바꿈
                    // System.out.println("i : " + i + ", j : " + j + ",arr[i] : " + arr[i]);
                    for (int k = 0; k < (i - j); k++) {
                        swap(arr, i - k, i - k - 1);
                    }
                }
            }
        }

        System.out.println(cnt);
    }

    public static void swap(char[] arr, int i, int j) {
        // System.out.println("arr : " + Arrays.toString(arr));
        char temp;
        temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
        // System.out.println("스왑 후 arr : " + Arrays.toString(arr));
    }
}