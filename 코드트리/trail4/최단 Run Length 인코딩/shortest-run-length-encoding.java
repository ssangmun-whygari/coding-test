import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char[] arr = str.toCharArray();

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            String encoded = encode(arr);
            // System.out.println("encoded : " + encoded);
            ans = Math.min(encoded.length(), ans);
            arr = shift(arr);
        }
        System.out.println(ans);
    }

    public static char[] shift(char[] arr) {
        char temp = arr[arr.length - 1];
        for (int i = arr.length - 1; i >= 1; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = temp;
        return arr;
    }

    public static String encode(char[] arr) {
        // System.out.println("arr : " + Arrays.toString(arr));
        Queue<Character> queue = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (char ch : arr) {
            if (queue.isEmpty()) {
                queue.add(ch);
                sb.append(ch);
            } else {
                char lastChar = queue.peek();
                if (ch == lastChar) {
                    queue.add(ch);
                } else {
                    // 큐에 있는 동일한 문자들을 다 꺼낸다.
                    int num = 0;
                    while (!queue.isEmpty()) {
                        queue.poll();
                        num++;
                    }
                    sb.append(num);
                    // 다시 새로운 글자를 큐에 넣는다.
                    queue.add(ch);
                    sb.append(ch);
                }
            }
        }
        if (!queue.isEmpty()) {
            sb.append(queue.size());
            // 큐 비우기 생략
        }
        return sb.toString();
    }
}