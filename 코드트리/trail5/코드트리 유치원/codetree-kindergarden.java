import java.util.*;

class Node {
    public int data;
    public Node prev;
    public Node next;
    Node(int data) {
        this.data = data;
    }
}

public class Main {
    public static int MAX_STUDENT = 100001;

    public static Node[] students = new Node[MAX_STUDENT + 1]; // 1 ~ 100001;

    public static int nextStudent = 2;

    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        for (int i = 1; i <= MAX_STUDENT; i++) {
            students[i] = new Node(i);
        }

        Scanner sc = new Scanner(System.in);
        int Q = sc.nextInt();
        for (int i = 0; i < Q; i++) {
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    insertBack(students[sc.nextInt()], sc.nextInt());
                break;
                case 2:
                    insertFront(students[sc.nextInt()], sc.nextInt());
                break;
                case 3:
                    Node target = students[sc.nextInt()];
                    sb.append(getAdjNo(target));
                break;
            }
        }

        System.out.print(sb.toString());
    }

    public static String getAdjNo(Node target) {
        if (target.prev == null || target.next == null) {
          return "-1\n";
        } else {
          return target.prev.data + " " + target.next.data + "\n";
        }
    }

    public static void insertFront(Node student, int num) {
        // student 앞에 num명을 삽입한다.
        for (int i = nextStudent; i < nextStudent + num - 1; i++) {
            // students[i], students[i + 1];
            connect(students[i], students[i + 1]);
        }

        students[nextStudent + num - 1].next = student;
        students[nextStudent].prev = student.prev; // student.prev가 null일수도 있음
        if (student.prev != null) {
            student.prev.next = students[nextStudent];
        }
        student.prev = students[nextStudent + num - 1];
        nextStudent += num;
    }

    public static void insertBack(Node student, int num) {
        // student 뒤에 num명을 삽입한다.

        for (int i = nextStudent; i < nextStudent + num - 1; i++) {
            // students[i], students[i + 1];
            connect(students[i], students[i + 1]);
        }

        students[nextStudent].prev = student;
        students[nextStudent + num - 1].next = student.next;
        if (student.next != null) {
            student.next.prev = students[nextStudent + num - 1];
        }
        student.next = students[nextStudent];
        nextStudent += num;
    }

    public static void connect(Node n1, Node n2) {
        if (n1 != null) {
            n1.next = n2;
        }
        if (n2 != null) {
            n2.prev = n1;
        }
    }
}