import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] L = new int[2];
        int[] R = new int[2];
        int[] B = new int[2];

        for (int i = 0; i < 10; i++) {
            String str = sc.next();
            for (int j = 0; j < 10; j++) {
                if (str.charAt(j) == 'L') {
                    L[0] = i; L[1] = j;
                } else if (str.charAt(j) == 'R') {
                    R[0] = i; R[1] = j;
                } else if (str.charAt(j) == 'B') {
                    B[0] = i; B[1] = j;
                }
            }
        }

        int ans = 0;
        if (L[0] == B[0] && L[0] == R[0]) { // L과 B가 같은 행에 있음
            if (Math.min(L[1], B[1]) < R[1] && R[1] < Math.max(L[1], B[1])) { // 사이에 R이 끼어듬
                ans = Math.max(L[1], B[1]) - Math.min(L[1], B[1]) + 1;
            } else {
                ans = Math.max(L[1], B[1]) - Math.min(L[1], B[1]) - 1;
            }
        } 
        else if (L[1] == B[1] && L[1] == R[1]) { // L과 B가 같은 열에 있음
            if (Math.min(L[0], B[0]) < R[0] && R[0] < Math.max(L[0], B[0])) { // 사이에 R이 끼어듬
                ans = Math.max(L[0], B[0]) - Math.min(L[0], B[0]) + 1;
            } else {
                ans = Math.max(L[0], B[0]) - Math.min(L[0], B[0]) - 1;
            }
        }
        // L과 B가 일직선 상에 없는 경우
        else {
            ans = Math.abs(L[0] - B[0]) + Math.abs(L[1] - B[1]) - 1;
        }

        System.out.println(ans);
    }
}