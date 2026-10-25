import java.util.*;

class Pair {
    public char lc;
    public char rc;
    Pair(char lc, char rc) {
        this.lc = lc;
        this.rc = rc;
    }
}


public class Main {
    public static StringBuilder sb;
    public static Map<Character, Pair> children = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            char parent = sc.next().charAt(0);
            char lc = sc.next().charAt(0);
            char rc = sc.next().charAt(0);
            children.put(parent, new Pair(lc, rc));
        }

        sb = new StringBuilder();
        preOrder('A');
        System.out.println(sb.toString());

        sb = new StringBuilder();
        midOrder('A');
        System.out.println(sb.toString());

        sb = new StringBuilder();
        postOrder('A');
        System.out.println(sb.toString());
    }

    public static void preOrder(char cur) {
        sb.append(cur);
        char lc = children.get(cur).lc;
        char rc = children.get(cur).rc;
        if (lc != '.') {
            preOrder(lc);
        }
        if (rc != '.') {
            preOrder(rc);
        }
    }

    public static void midOrder(char cur) {
        char lc = children.get(cur).lc;
        char rc = children.get(cur).rc;
        if (lc != '.') {
            midOrder(lc);
        }
        sb.append(cur);
        if (rc != '.') {
            midOrder(rc);
        }
    }

    public static void postOrder(char cur) {
        char lc = children.get(cur).lc;
        char rc = children.get(cur).rc;
        if (lc != '.') {
            postOrder(lc);
        }
        if (rc != '.') {
            postOrder(rc);
        }
        sb.append(cur);
    }
}