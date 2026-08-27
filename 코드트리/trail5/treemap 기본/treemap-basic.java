import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        Map<Integer, Integer> map = new TreeMap<>();
        
        for (int i = 0; i < n; i++) {
            String cmd = sc.next();
            if ("add".equals(cmd)) {
                int key = sc.nextInt();
                int value = sc.nextInt();
                map.put(key, value);
            } else if ("remove".equals(cmd)) {
                int key = sc.nextInt();
                map.remove(key);
            } else if ("find".equals(cmd)) {
                int key = sc.nextInt();
                if (map.containsKey(key)) {
                    System.out.println(map.get(key));
                } else {
                    System.out.println("None");
                }
            } else if ("print_list".equals(cmd)) {
                if (map.isEmpty()) {
                    System.out.println("None");
                    continue;
                }
                Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<Integer, Integer> entry = it.next();
                    System.out.print(entry.getValue() + " ");
                }
                System.out.print("\n");
            } else {
                throw new RuntimeException("예상 외 입력");
            }
        }
    }
}