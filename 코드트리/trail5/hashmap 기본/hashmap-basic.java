import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String cmd = sc.next();
            if ("add".equals(cmd)) {
                int key = sc.nextInt();
                int value = sc.nextInt();
                map.put(key, value);
            } else if ("remove".equals(cmd)) {
                int key = sc.nextInt();
                if (map.containsKey(key)) {
                    map.remove(key);
                }
            } else if ("find".equals(cmd)) {
                int key = sc.nextInt();
                if (map.containsKey(key)) {
                    System.out.println(map.get(key));
                } else {
                    System.out.println("None");
                }
            } else {
                throw new RuntimeException("이상한 입력");
            }
        }
    }
}