import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        
        // i : i번쨰 자리수를 검사
        // i = 0 : 1의 자리, 1 : 10의 자리, 2 : 100의 자리...
        for (int i = 0; i <= 5; i++) {
            List<Integer>[] list = new ArrayList[10];
            for (int j = 0; j < 10; j++) {
                list[j] = new ArrayList<Integer>();
            }

            // 123456 / 1 % 10
            // 123456 / 10 % 10
            // ...
            for (int j = 0; j < n; j++) {
                int digit = arr[j] / ((int) Math.pow(10, i)) % 10;
                list[digit].add(arr[j]);
            }

            // System.out.println("i : " + i);
            // for (int j = 0; j < 10; j++) {
            //     System.out.println(j + " : " + list[j]);
            // }

            int[] newArr = new int[n];
            int idx = 0;
            while (idx < arr.length) {
                for (int j = 0; j < 10; j++) {
                    for (int k = 0; k < list[j].size(); k++) {
                        // System.out.println(list[j].get(k).getClass());
                        newArr[idx++] = list[j].get(k);
                    }
                }
            }
             // System.out.println("newArr : " + Arrays.toString(newArr));
             arr = newArr;
        }

        for (int a : arr) {
            System.out.print(a + " ");
        }


    }
}