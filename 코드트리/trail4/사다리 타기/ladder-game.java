import java.util.*;

class Pair {
  int x, y;
  Pair(int x, int y) {
    this.x = x;
    this.y = y;
  }
}

public class Main {
  public static int[] allSelected;
  public static int N;
  public static int M;
  public static boolean[][] Ladders;
  public static List<Pair> LadderList;
  public static int ans = Integer.MAX_VALUE;


  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    M = sc.nextInt();

    boolean[][] ladders = new boolean[15 + 1][N];
    LadderList = new ArrayList<>();

    for (int i = 0; i < M; i++) {
        int y = sc.nextInt();
        int x = sc.nextInt();
        ladders[x - 1][y - 1] = true;
        LadderList.add(new Pair(x - 1, y - 1));
    }

    allSelected = new int[N];
    // 모든 사다리 줄을 선택했을 때 상태를 시뮬레이션
    for (int i = 0; i < N; i++) {
        int x = 0;
        int y = i;

        while (x < ladders.length - 1) {
            // ladders[x][y], ladders[x][y - 1]
            if (ladders[x][y] == true) {
                // 오른쪽에 있는 가로줄을 탁고 간다.
                x += 1;
                y += 1;
            } else if (y >= 1 && ladders[x][y - 1] == true) {
                // 왼쪽에 있는 가로줄을 타고 간다.
                x += 1;
                y -= 1;
            } else {
                x += 1;
            }
        }
        allSelected[i] = y;
    }
    
    List<Boolean> selected = new ArrayList<>();
    Ladders = new boolean[15 + 1][N];
    recur(selected);

    System.out.println(ans);
  }

  public static void recur(List<Boolean> selected) {
    if (selected.size() >= M) {
        // 선택된 사다리에 대해서 시뮬레이션
        int cnt = simulate(selected);
        ans = Math.min(cnt, ans);
        return;
    }
    selected.add(false);
    recur(selected);
    selected.remove(selected.size() - 1);

    selected.add(true);
    recur(selected);
    selected.remove(selected.size() - 1);
  }

  public static int simulate(List<Boolean> selected) {
    // Ladders 초기화
    for (int i = 0; i < Ladders.length; i++) {
        for (int j = 0; j < Ladders[0].length; j++) {
            Ladders[i][j] = false;
        }
    }

    for (int i = 0; i < M; i++) {
        if (selected.get(i) == true) {
            Ladders[LadderList.get(i).x][LadderList.get(i).y] = true;
        }
    }

    boolean same = true;
    for (int i = 0; i < N; i++) {
        int x = 0;
        int y = i;

        while (x < Ladders.length - 1) {
            if (Ladders[x][y] == true) {
                // 오른쪽에 있는 가로줄을 탁고 간다.
                x += 1;
                y += 1;
            } else if (y >= 1 && Ladders[x][y - 1] == true) {
                // 왼쪽에 있는 가로줄을 타고 간다.
                x += 1;
                y -= 1;
            } else {
                x += 1;
            }
        }
        if (allSelected[i] != y) {
            same = false;
            break;
        }
    }

    if (same) {
        int cnt = 0;
        for (boolean bool : selected) {
            if (bool == true) cnt++;
        }
        return cnt;
    } else {
        return M;
    }
  }

  public static void printGrid(boolean[][] grid) {
    System.out.println("####grid : ");
    for (boolean[] row : grid) {
      System.out.println(Arrays.toString(row));
    }
    System.out.println("####grid end");
  }
}