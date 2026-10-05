import java.util.*;

class Black implements Comparable<Black> {
    public int lo, hi;

    Black(int lo, int hi) {
        this.lo = lo;
        this.hi = hi;
    }

    @Override
    public int compareTo(Black other) {
        if (this.hi != other.hi) {
            return Integer.compare(this.lo, other.lo);
        } else {
            return Integer.compare(this.hi, other.hi);
        }
    }

    @Override
    public String toString() {
        return "Black[lo:" + lo + ",hi:" + hi + "]" ;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        int n = sc.nextInt();

        int[] red = new int[c];
        for (int i = 0; i < c; i++) {
            red[i] = sc.nextInt();
        }
        Arrays.sort(red);

        PriorityQueue<Black> black = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            black.add(new Black(sc.nextInt(), sc.nextInt()));
        }

        TreeSet<Black> available = new TreeSet<>((e1, e2) -> {
            if (e1.hi != e2.hi) {
                return Integer.compare(e1.hi, e2.hi);
            } else {
                return Integer.compare(e1.lo, e2.lo);
            }
        });

        int cnt = 0;
        for (int i = 0; i < c; i++) {
            // 하한이 red[i] 이하인 검은 돌을 다 꺼낸다.
            while (!black.isEmpty() && black.peek().lo <= red[i]) {
                available.add(black.poll());
            }

            Black selected = available.ceiling(new Black(0, red[i]));
            if (selected != null) {
                // System.out.println("red : " + red[i] + ", 선택된 검은 돌 : " + selected);
                available.remove(selected);
                cnt++;
            }
        }

        System.out.print(cnt);
    }
}