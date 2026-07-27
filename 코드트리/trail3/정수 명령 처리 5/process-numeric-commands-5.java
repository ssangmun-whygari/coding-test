import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int N = sc.nextInt();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String cmd = sc.next();
            if (cmd.equals("push_back")) {
                int arg = sc.nextInt();
                list.add(arg);
            } else if (cmd.equals("pop_back")) {
                list.remove(list.size() - 1);
            } else if (cmd.equals("size")) {
                System.out.println(list.size());
            } else if (cmd.equals("get")) {
                int arg = sc.nextInt();
                System.out.println(list.get(arg - 1));
            }
        }
    }
}