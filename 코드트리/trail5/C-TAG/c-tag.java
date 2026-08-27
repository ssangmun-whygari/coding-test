import java.util.*;

public class Main {
    public static Set<String> set = new HashSet<>();
    public static int n;
    public static int m;
    public static String[] groupA;
    public static String[] groupB;
    public static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        groupA = new String[n];
        groupB = new String[n];
        for (int i = 0; i < n; i++) {
            groupA[i] = sc.next();
        }
        for (int i = 0; i < n; i++) {
            groupB[i] = sc.next();
        }

        bt(-1, new ArrayList<Integer>());

        System.out.print(answer);
    }

    public static void process(List<Integer> idxList) {
        int x0 = idxList.get(0);
        int x1 = idxList.get(1);
        int x2 = idxList.get(2);
        set.clear();

        for (int i = 0; i < n; i++) {
            String seq = "" + groupA[i].charAt(x0) + groupA[i].charAt(x1) + groupA[i].charAt(x2);
            set.add(seq);
        }

        boolean result = true;
        for (String b : groupB) {
            String seq = "" + b.charAt(x0) + b.charAt(x1) + b.charAt(x2);
            if (set.contains(seq)) {
                result = false;
                break;
            }
        }

        if (result == true) {
            // System.out.println(idxList);
            answer++;
        }
    }

    public static void bt(int x, List<Integer> idxList) {
        if (idxList.size() == 3) {
            process(idxList);
            return;
        }

        for (int i = x + 1; i < m; i++) {
            idxList.add(i);
            bt(i, idxList);
            idxList.remove(idxList.size() - 1);
        }
    }
}