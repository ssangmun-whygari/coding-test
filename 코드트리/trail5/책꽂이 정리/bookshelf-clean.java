import java.util.*;

class Book {
    public int id; // globally 고유한 책의 번호
    public int no; // 책에 적혀있던 번호
    public Book prev, next;
    Book(int id, int no) {
        this.id = id;
        this.no = no;
    }

    @Override
    public String toString() {
      return "[id:" + this.id + ",no:" + this.no + "]";
    }
}

class Shelf {
    public static HashMap<Integer, Book> books = new HashMap<>();
    public Book head;
    public Book tail;
    Shelf(int startId, int n) {
        initialize(startId, n);
    }

    private void initialize(int startId, int n) {
        if (startId != 0) return;

        for (int i = 1; i <= n; i++) {
            books.put(startId + i, new Book(startId + i, i));
        }
        for (int i = 1; i < n; i++) {
            books.get(startId + i).next = books.get(startId + i + 1);
            books.get(startId + i + 1).prev = books.get(startId + i);
        }
        this.head = books.get(startId + 1);
        this.tail = books.get(startId + n);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int q = sc.nextInt();

        Shelf[] shelf = new Shelf[k + 1]; // 1 ~ K
        for (int i = 1; i <= k; i++) {
            // i = 1, n = 10이라면 startId = 0, 10, 20, ...
            shelf[i] = new Shelf((i - 1) * n, n);
        }

        for (int i = 0; i < q; i++) {
            int cmd = sc.nextInt();
            Shelf xShelf = shelf[sc.nextInt()];
            Shelf yShelf = shelf[sc.nextInt()];
            switch (cmd) {
                case 1:
                    addToTail(xShelf, yShelf);
                break;
                case 2:
                    addToHead(xShelf, yShelf);
                break;
                case 3:
                    addAllToHead(xShelf, yShelf);
                break;
                case 4:
                    addAllToTail(xShelf, yShelf);
                break;
            }
        }

        for (int i = 1; i <= k; i++) {
            StringBuilder sb = new StringBuilder();
            Shelf s = shelf[i];
            if (s.head == null) {
                System.out.println(0);
                continue;
            } else {
                Book book = s.head;
                int cnt = 0;
                while (book != null) {
                    sb.append(book.no);
                    sb.append(' ');
                    book = book.next;
                    cnt++;
                }
                sb.insert(0, cnt + " ");
                System.out.println(sb.toString());
            }
        }
    }

    public static void addAllToTail(Shelf xShelf, Shelf yShelf) {
        // xShelf의 모든 책을 yShelf의 맨 뒤로 옮긴다.
        if (xShelf == yShelf) return;
        if (xShelf.tail == null) return; // xShelf가 비어있다.

        connect(yShelf.tail, xShelf.head);

        if (yShelf.head == null) { // yShelf가 비어있었음
            yShelf.head = xShelf.head;
        }
        yShelf.tail = xShelf.tail;

        xShelf.head = xShelf.tail = null;
    }

    public static void addAllToHead(Shelf xShelf, Shelf yShelf) {
        // xShelf의 모든 책을 yShelf의 맨 앞으로 옮긴다.
        if (xShelf == yShelf) return;
        if (xShelf.tail == null) return; // xShelf가 비어있다.

        connect(xShelf.tail, yShelf.head);
        
        if (yShelf.head == null) { // yShelf가 비어있었음
            yShelf.tail = xShelf.tail;
        }
        yShelf.head = xShelf.head;

        xShelf.head = xShelf.tail = null;
    }

    public static void addToHead(Shelf xShelf, Shelf yShelf) {
        // xShelf의 맨 뒷 책을 yShelf의 맨 앞에 꽂는다.
        Book book = xShelf.tail;
        if (book == null) return;

        if (xShelf.tail.prev != null) {
          xShelf.tail = xShelf.tail.prev; // xShelf의 tail이 바뀐다.
        } else { // xShelf에 요소가 하나밖에 없다.
          xShelf.head = xShelf.tail = null;
        }
          
        Book target = yShelf.head;
        if (target == null) { // yShelf가 비어있다.
            pop(book);

            yShelf.head = book;
            yShelf.tail = book;
        } else {
            pop(book);
            if (target != book) connect(book, target); // 순환참조 방지

            yShelf.head = book; // 맨 앞에 넣으면 head가 바뀐다.
        }
    }

    public static void addToTail(Shelf xShelf, Shelf yShelf) {
        // xShelf의 맨 앞 책을 yShelf의 맨 뒤에 꽂는다.
        Book book = xShelf.head;
        if (book == null) return;

        if (xShelf.head.next != null) {
          xShelf.head = xShelf.head.next; // xShelf의 head가 바뀐다.
        } else { // xShelf에 요소가 하나밖에 없다.
          xShelf.head = xShelf.tail = null;
        }
          
        Book target = yShelf.tail;
        if (target == null) { // yShelf가 비어있다.
            pop(book);

            yShelf.head = book;
            yShelf.tail = book;
        } else {
            pop(book);
            if (target != book) connect(target, book); // 순환참조 방지

            yShelf.tail = book; // 맨 뒤에 넣으면 tail이 바뀐다.
        }
    }

    public static void connect(Book b1, Book b2) {
        if (b1 == b2) return; // 순환참조 방지
        if (b1 != null) {
            b1.next = b2;
        }
        if (b2 != null) {
            b2.prev = b1;
        }
    }
    
    // book을 singleton으로 만든다.
    public static Book pop(Book book) {
        if (book.next != null) {
            book.next.prev = null;
            book.next = null;
        }
        if (book.prev != null) {
            book.prev.next = null;
            book.prev = null;
        }
        return book;
    }
}