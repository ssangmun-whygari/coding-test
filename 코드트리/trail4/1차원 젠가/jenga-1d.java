import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] blocks = new int[N];
        for (int i = 0; i < N; i++) {
            blocks[i] = sc.nextInt(); // 왼쪽이 위쪽
        }

        int s1 = sc.nextInt() - 1, e1 = sc.nextInt() - 1;
        int[] blocks2 = new int[N];
        int endOfBlocks = 0;
        int endOfBlocks2 = 0;
        while (endOfBlocks < N) {
            if (endOfBlocks < s1 || endOfBlocks > e1) {
                blocks2[endOfBlocks2++] = blocks[endOfBlocks++];
            } else {
                endOfBlocks++;
            }
        }
        // System.out.println(Arrays.toString(blocks2));

        int s2 = sc.nextInt() - 1, e2 = sc.nextInt() - 1;
        int[] blocks3 = new int[N];
        endOfBlocks2 = 0;
        int endOfBlocks3 = 0;
        while (blocks2[endOfBlocks2] > 0) {
            if (endOfBlocks2 < s2 || endOfBlocks2 > e2) {
                blocks3[endOfBlocks3++] = blocks2[endOfBlocks2++];
            } else {
                endOfBlocks2++;
            }
        }
        // System.out.println(Arrays.toString(blocks3));

        System.out.println(endOfBlocks3);
        for (int i = 0; i < endOfBlocks3; i++) {
            System.out.println(blocks3[i]);
        }

    }
}