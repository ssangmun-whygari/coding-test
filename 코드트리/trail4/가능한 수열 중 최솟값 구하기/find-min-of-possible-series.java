import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        bt("", 0, n);

        System.out.println(ans);
    }

    public static String ans = null;

    public static void bt(String seq, int k, int n) {
        if (ans != null) return;

        if (k == 0) {
            for (int i = 4; i <= 6; i++) {
                bt(String.valueOf(i), k + 1, n);
            }
        } else if (k < n) {
            for (int j = 4; j <= 6; j++) {
                boolean canAppend = true;
                String newSeq = seq + String.valueOf(j);
                for (int i = 0; i < (seq.length() + 1) / 2; i++) {
                    String substr1 = newSeq.substring(newSeq.length() - i - 1);
                    String substr2 = newSeq.substring(newSeq.length() - (i + 1)*2  , newSeq.length() - i - 1);
                    if (substr1.equals(substr2)) {
                        canAppend = false;
                    }
                }
                if (canAppend) {
                    bt(newSeq, k + 1, n);
                }
            }
        } else {
            if (ans == null) {
                ans = seq;
            }
            return;
        }
    }
}