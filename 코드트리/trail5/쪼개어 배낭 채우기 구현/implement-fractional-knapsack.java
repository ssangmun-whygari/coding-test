import java.util.*;

class Pair implements Comparable<Pair> {
    public int w, v;

    Pair (int weight, int value) {
        this.w = weight;
        this.v = value;
    }

    @Override
    public int compareTo(Pair other) {
        double myRatio = (double) this.v / this.w;
        double otherRatio = (double) other.v / other.w;
        return Double.compare(otherRatio, myRatio);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        Pair[] jewel = new Pair[n];

        for (int i = 0; i < n; i++) {
            int w = sc.nextInt();
            int v = sc.nextInt();

            jewel[i] = new Pair(w, v);
        }
        Arrays.sort(jewel);

        double sumVal = 0.0;
        int sumWeight = 0;
        for (int i = 0; i < n; i++) {
            if (sumWeight + jewel[i].w <= m) {
                sumWeight += jewel[i].w;
                sumVal += jewel[i].v;
            } else {
                double diff = m - sumWeight; // 더 채우고 싶은 무게
                sumVal += ((double) jewel[i].v / jewel[i].w) * diff;
                sumWeight = m;
                break;
            }
        }

        System.out.printf("%.3f", sumVal);
    }
}