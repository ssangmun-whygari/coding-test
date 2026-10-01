import java.util.*;
public class Main {
    public static int[] del;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String B = sc.next();
        int n = A.length();
        del = new int[n];
        for (int i = 0; i < n; i++) {
            del[i] = sc.nextInt() - 1;
        }

        int left = 0; // 하나도 안잘랐을 때 
        int right = A.length(); // 빈 문자열일때
        int ans = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (is_possible(mid, A, B)) {
                left = mid + 1;
                ans = Math.max(mid, ans);
            } else {
                right = mid - 1;
            }
        }

        // for (int i = 0; i <= A.length(); i++) {
        //     System.out.println("i : " + i + ", is_possible : " + is_possible(i, A, B));
        // }

        System.out.print(ans + 1);
    }

    public static boolean is_possible(int x, String A, String B) {
        // x번째 순서까지 지웠을 때 부분수열 조건을 만족하는가?
        String cropped = crop(A, x);
        // cropped가 B를 포함하는가?
        int j = 0;
        for (int i = 0; i < B.length(); i++) {
            while (j < cropped.length() && cropped.charAt(j) != B.charAt(i)) {
                j++;
            }

            if (j >= cropped.length()) {
                return false;
            }

            j++;
        }
        return true;
    }

    public static String crop(String A, int x) {
        // x번째 순서까지 지우기 (ex : 0이면 하나도 안 지움)
        Set<Integer> idx = new HashSet<>();
        for (int i = 0; i < x; i++) {
            idx.add(del[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < A.length(); i++) {
            if (!idx.contains(i)) {
                sb.append(A.charAt(i));
            }
        }

        return sb.toString();
    }
}