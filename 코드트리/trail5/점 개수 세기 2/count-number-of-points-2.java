import java.util.*;
import java.io.*;

public class Main {
    public static int MAX_LEN = 2500;
    public static int[][] grid = new int[MAX_LEN + 1][MAX_LEN + 1];
    public static int[][] pfSum = new int[MAX_LEN + 1][MAX_LEN + 1];
    public static TreeSet<Integer> setX;
    public static TreeSet<Integer> setY;
    public static Map<Integer, Integer> mapX;
    public static Map<Integer, Integer> mapY;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        int[] pointX = new int[N];
        int[] pointY = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            pointX[i] = Integer.parseInt(st.nextToken());
            pointY[i] = Integer.parseInt(st.nextToken());
        }

        setX = new TreeSet<>();
        setY = new TreeSet<>();
        for (int x : pointX) {
            setX.add(x);
        }
        for (int y : pointY) {
            setY.add(y);
        }

        mapX = new HashMap<>();
        mapY = new HashMap<>();
        int x = 1;
        for (int i : setX) {
            mapX.put(i, x++);
        }
        int y = 1;
        for (int i : setY) {
            mapY.put(i, y++);
        }
        
        // grid 배열 작성
        for (int i = 0; i < N; i++) {
            int nx = mapX.get(pointX[i]);
            int ny = mapY.get(pointY[i]);
            grid[nx][ny] = 1;
        }
        // 부분합 배열 작성
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                pfSum[i][j] = (pfSum[i - 1][j] + pfSum[i][j - 1] - pfSum[i - 1][j - 1] + grid[i][j]);
            }
        }

        // System.out.print(printGrid(grid));
        // System.out.print(printGrid(pfSum));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int result = getCount(Math.min(x1, x2), Math.min(y1, y2), Math.max(x1, x2), Math.max(y1, y2));

            sb.append(result + "\n");
        }
        System.out.print(sb.toString());
    }

    public static String printGrid(int[][] grid) {
      StringBuilder sb = new StringBuilder();
      for (int i = 1; i < grid.length; i++) {
        for (int j = 1; j < grid.length; j++) {
          sb.append(grid[i][j] + " ");
        }
        sb.append("\n");
      }

      return sb.toString();
    }

    public static int getCount(int x1, int y1, int x2, int y2) {
        Integer nx1 = mapX.get(setX.ceiling(x1));
        Integer ny1 = mapY.get(setY.ceiling(y1));
        Integer nx2 = mapX.get(setX.floor(x2));
        Integer ny2 = mapY.get(setY.floor(y2));

        if (nx1 == null || ny1 == null || nx2 == null || ny2 == null) return 0;

        int result = pfSum[nx2][ny2] - pfSum[nx1 - 1][ny2] - pfSum[nx2][ny1 - 1] + pfSum[nx1 - 1][ny1 - 1];
        return result;
    }
}