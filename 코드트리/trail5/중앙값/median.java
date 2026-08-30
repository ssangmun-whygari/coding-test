import java.util.*;

public class Main {
    public static PriorityQueue<Integer> maxPQ = new PriorityQueue<>(); // 내림차순 정렬
    public static PriorityQueue<Integer> minPQ = new PriorityQueue<>(); // 오름차순 정렬
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0) {
            int m = sc.nextInt();
            int[] arr = new int[m];
            for(int i = 0; i < m; i++)
                arr[i] = sc.nextInt();
            
            minPQ.clear();
            maxPQ.clear();

            int mid = arr[0];
            sb.append(mid + " ");
            for (int i = 1; i < arr.length; i = i + 2) {
                int n1 = arr[i];
                int n2 = arr[i + 1];
                int num = 0; // minPQ에 삽입됩 횟수
                if (n1 >= mid) {
                    minPQ.add(n1);
                    num++;
                } else {
                    maxPQ.add(-n1);
                }
                if (n2 >= mid) {
                    minPQ.add(n2);
                    num++;
                } else {
                    maxPQ.add(-n2);
                }

                if (num == 0) { // maxPQ에만 들어감 -> 현재 중앙값보다 새로 들어온 숫자들이 작음
                    minPQ.add(mid);
                    mid = maxPQ.poll() * -1;

                } else if (num == 2) { // minPQ에만 들어감 -> 현재 중앙값보다 새로 들어온 숫자들이 크거나 같음
                    maxPQ.add(-mid);
                    mid = minPQ.poll();
                } else {
                    // 중앙값이 유지됨
                }
                sb.append(mid + " ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}