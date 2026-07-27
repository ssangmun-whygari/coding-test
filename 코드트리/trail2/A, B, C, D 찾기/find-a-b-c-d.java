import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[15];

        for (int i = 0; i < 15; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        int A = arr[0];
        int B = arr[1];
        int ABCD = arr[arr.length - 1];
        int CD = ABCD - A - B;
        int x = arr[arr.length - 4]; // x는 CD나 ABD 중 하나
        
        // ... ABC ABD CD ACD BCD ABCD

        // ... ABC CD ABD ACD BCD ABCD

        // ... CD ABC ABD ACD BCD ABCD
        int ABD = 0;
        if (x == CD) {
            ABD = arr[arr.length - 5];
        } else {
            ABD = x;
        }

        int D = ABD - A - B;
        int C = ABCD - A - B - D;

        System.out.println(A + " " + B + " " + C + " " + D);

        // BCD
        // ACD

        // ABD
        // ABC

        // AB
        // AC
        // AD
        // BC
        // BD
        // CD
    }
}