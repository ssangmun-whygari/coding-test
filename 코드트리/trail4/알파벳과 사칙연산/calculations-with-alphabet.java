import java.util.*;

public class Main {
    public static String expr;
    public static int ans = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        expr = sc.next();
        
        // a, b, c, d, e, f
        List<Integer> assigned = new ArrayList<>();
        recur(assigned);
        System.out.println(ans);
    }

    public static void recur(List<Integer> assigned) {
        if (assigned.size() >= 6) {
            int result = eval(assigned);
            ans = Math.max(ans, result);
            return;
        }

        for (int i = 1; i <= 4; i++) {
            assigned.add(i);
            recur(assigned);
            assigned.remove(assigned.size() - 1);
        }
    }

    public static int eval(List<Integer> assigned) {
        int result = 0;
        int nextNum = 0;
        char lastOp = '\u0000';
        for (int i = 0; i < expr.length(); i++) {
            char ch = expr.charAt(i);
            if (ch - 'a' >= 0) { // ch = 'a', 'b', 'c' ...
                if (i == 0) {
                    result = assigned.get(ch - 'a');
                } else {
                    nextNum = assigned.get(ch - 'a');
                    if (lastOp == '+') {
                        result = result + nextNum;
                    } else if (lastOp == '-') {
                        result = result - nextNum;
                    } else if (lastOp == '*') {
                        result = result * nextNum;
                    }
                }
            } else {
                lastOp = ch;
            }
        }
        return result;
    }
}