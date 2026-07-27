import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        String str = sc.next();

        List<Character> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            list.add(str.charAt(i));
        }

        // System.out.println("list : " + list);
        ListIterator<Character> it = list.listIterator(list.size());
        int last = -1; // add() : -1, previous() : 0, next() : 1

        for (int i = 0; i < m; i++) {
            String cmd = sc.next();
            if ("L".equals(cmd)) {
                if (it.hasPrevious()) {
                    it.previous();
                    last = 0;
                }
            } else if ("R".equals(cmd)) {
                if (it.hasNext()) {
                    it.next();
                    last = 1;
                }
            } else if ("D".equals(cmd)) {
                if (!it.hasNext()) continue; // 뒤에 있는 요소가 없어서 못 지움
                if (last == -1) {
                    // prev(), next()가 한번도 안불렸거나 add() 호출 후 prev(), next()를 부르지 않음
                    it.next();
                    it.previous();
                    it.remove();
                } else if (last == 0) {
                    it.next();
                    it.previous();
                    it.remove();
                } else if (last == 1) {
                    it.next();
                    it.remove();
                }
            } else if ("P".equals(cmd)) {
                Character arg = sc.next().charAt(0);
                it.add(arg);
                last = -1;
            }
        }

        it = list.listIterator();
        while (it.hasNext()) {
            System.out.print(it.next());
        }
    }
}