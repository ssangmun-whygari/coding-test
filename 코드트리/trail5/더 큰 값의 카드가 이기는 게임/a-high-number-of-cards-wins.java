import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] bCards = new int[n];
        for (int i = 0; i < n; i++) {
            bCards[i] = sc.nextInt();
        }

        TreeSet<Integer> aCards = new TreeSet<>();
        for (int i = 1; i <= 2 * n; i++) {
            aCards.add(i);
        }
        for (int i = 0; i < n; i++) {
            aCards.remove(bCards[i]);
        }

        int score = 0;
        for (int i = 0; i < n; i++) {
            Integer card = aCards.higher(bCards[i]);
            if (card != null) {
                aCards.remove(card);
                score++;
            } else {
                aCards.remove(aCards.first()); // 어차피 지는 데 제일 작은 거 낸다
            }
        }

        System.out.print(score);
    }
}