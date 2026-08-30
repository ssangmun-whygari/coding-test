import java.util.*;

class Problem implements Comparable<Problem> {
    public int hard, no;

    Problem(int hard, int no) {
        this.hard = hard;
        this.no = no;
    }

    @Override
    public int compareTo(Problem other) {
        if (this.hard != other.hard) {
            return Integer.compare(this.hard, other.hard);
        } else {
            return Integer.compare(this.no, other.no);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        TreeSet<Problem> set = new TreeSet<>();
        for (int i = 0; i < N; i++) {
            int no = sc.nextInt();
            int hard = sc.nextInt();
            set.add(new Problem(hard, no));
        }

        int M = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String cmd = sc.next();
            if ("rc".equals(cmd)) {
                int param = sc.nextInt();
                switch (param) {
                    case 1:
                        sb.append(set.last().no + "\n");
                        break;
                    case -1:
                        sb.append(set.first().no + "\n");
                        break;
                }
            } else if ("ad".equals(cmd)) {
                int no = sc.nextInt();
                int hard = sc.nextInt();
                set.add(new Problem(hard, no));
            } else if ("sv".equals(cmd)) {
                int no = sc.nextInt();
                int hard = sc.nextInt();
                set.remove(new Problem(hard, no));
            }
        }
        System.out.print(sb.toString());
    }
}