import java.util.*;

class Unit implements Comparable<Unit> {
    public String value;

    Unit(String value) {
        this.value = value;
    }

    @Override
    public int compareTo(Unit other) {
        long s1 = Unit.getScore(this.value, other.value);
        long s2 = Unit.getScore(other.value, this.value);
        int result = (s1 > s2) ? -1 : (s1 < s2) ? 1 : 0;
        return result;
    }

    public static long getScore(String s1, String s2) {
        int lc = 0; // '('의 개수
        long score = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == '(') {
                lc += 1;
            } else if (s1.charAt(i) == ')') {
                score += lc;
            }
        }
        for (int i = 0; i < s2.length(); i++) {
            if (s2.charAt(i) == '(') {
                lc += 1;
            } else if (s2.charAt(i) == ')') {
                score += lc;
            }
        }
        return score;
    }

    @Override
    public String toString() {
        return this.value;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Unit[] arr = new Unit[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Unit(sc.next());
        }
        
        Arrays.sort(arr);
        // System.out.println(Arrays.toString(arr));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(arr[i].value);
        }
        
        System.out.println(Unit.getScore(sb.toString(), ""));
    }
}