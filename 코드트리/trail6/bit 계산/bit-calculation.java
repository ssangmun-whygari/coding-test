import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();

        int set = 0;
        for (int i = 0; i < q; i++) {
            String cmd = sc.next();
            int param = 0;
            int exist = 0;
            switch (cmd) {
                case "add":
                    param = sc.nextInt();
                    set = set | (1 << param);
                break;
                case "delete":
                    param = sc.nextInt();
                    exist = 1 & (set >> param);
                    if (exist == 1) {
                        set = set ^ (1 << param);
                    }
                break;
                case "print":
                    param = sc.nextInt();
                    exist = 1 & (set >> param);
                    System.out.println(exist);
                break;
                case "toggle":
                    param = sc.nextInt();
                    set = set ^ (1 << param);
                break;
                case "clear":
                    set = 0;
                break;
            }
        }
    }
}