import java.util.*;

class Person implements Comparable<Person> {
    public int no, arriveAt, span;
    Person(int n, int a, int s) {
        no = n;
        arriveAt = a;
        span = s;
    }

    @Override
    public int compareTo(Person other) {
        if (this.arriveAt != other.arriveAt) {
            return Integer.compare(this.arriveAt, other.arriveAt);
        } else {
            return Integer.compare(this.no, other.no);
        }
    }

    @Override
    public String toString() {
      return "[no:" + no + ",도착시간:" + arriveAt + ",체류시간:" + span + "]";
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Person> visitors = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int arriveAt = sc.nextInt();
            int span = sc.nextInt();
            visitors.add(new Person(i, arriveAt, span));
        }

        PriorityQueue<Person> waiting = new PriorityQueue<>((p1, p2) -> {
          return Integer.compare(p1.no, p2.no);
        });
        
        int ans = 0;
        Person curP = null;
        int enterT = 0;
        while (true) {
            if (waiting.isEmpty()) {
              if (visitors.size() > 0) {
                curP = visitors.poll();
                // System.out.println("curP : " + curP + " // 대기없이 입장");
                enterT = curP.arriveAt + curP.span;
              } else {
                break;
              }
            } else {
              curP = waiting.poll();
              // System.out.println("curP : " + curP + " // 대기시간 : " + (enterT - curP.arriveAt));
              ans = Math.max(enterT - curP.arriveAt, ans);
              enterT = enterT + curP.span;
            }

            // 기다려야 하는 사람 pq에 넣기
            while (!visitors.isEmpty()) {
                Person visitor = visitors.peek();
                if (visitor.arriveAt < enterT) {
                    Person p = visitors.poll();
                    waiting.add(p);
                } else {
                    break;
                }
            }

            if (waiting.isEmpty() && visitors.isEmpty()) {
              break;
            }
        }

        System.out.print(ans);
    }
}