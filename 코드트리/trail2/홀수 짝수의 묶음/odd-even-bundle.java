import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int evenNum = 0, oddNum = 0;
        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            if (num % 2 == 0) {
                evenNum++;
            } else {
                oddNum++;
            }
        }
        // System.out.println("evenNum : " + evenNum);
        // System.out.println("oddNum : " + oddNum);

        int ans = 0;
        // 짝수의 수가 홀수의 수 이상일때
        // 예) 짝수 10, 홀수 3
        // 짝 + 짝 = 짝 or 짝 + 홀 = 홀으로 짝수의 개수를 하나 감소시킬 수 있다.
        // 따라서 홀수의 수 or (홀수의 수 + 1)로 만들 수 있다
        if (evenNum > oddNum) {
            evenNum = oddNum + 1;
            ans = evenNum + oddNum;
        } else if (evenNum == oddNum) {
            ans = evenNum + oddNum;
        } else {
        // 짝수의 수가 홀수의 수 미만일때
        // 예) 짝수 3, 홀수 10
        // 홀수 2개를 뭉쳐서 짝수로 만들 수 있다.
            while (evenNum < oddNum) {
                oddNum -= 2;
                evenNum += 1;
            }
            // 홀수를 2개씩 감소시키기 때문에 쩍수거 2만큼 더 클 수도 있다.
            // (0, 6) => (1, 4) => (2, 2) 이 경우엔 OK
            // (0, 7) => (1, 5) => (2, 3) => (3, 1) 추가 보정 필요
            // 
            if (evenNum > oddNum) {
                evenNum = oddNum + 1;
            }
            ans = evenNum + oddNum;
        }
        System.out.println(ans);

        // 짝 + 짝 = 짝
        // 홀 + 홀 = 짝
        // 짝 + 홀 = 홀
        // 홀 + 짝 = 홀

        // 홀수의 개수가 짝수여야 함
        // 짝
        // 짝, 짞
        // 짝, 짝, 짝
        // 짝, 홀, 홀

        // 홀수의 개수가 홀수여야 함
        // 홀
        // 홀, 짝
        // 홀, 짝, 짝
        // 홀, 홀, 홀
    }
}