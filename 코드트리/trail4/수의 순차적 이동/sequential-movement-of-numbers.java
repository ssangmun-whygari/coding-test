import java.util.*;

class Cell {
    public int x, y, value;
    Cell(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }
}

public class Main {
    public static int[][] grid;
    public static int n;
    public static int[] dx = new int[] {-1, -1, -1, 0, 0, 1, 1, 1};
    public static int[] dy = new int[] {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        
        List<Cell> cells = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cells.add(new Cell(i, j, grid[i][j]));
            }
        }
        Collections.sort(cells, (c1, c2) -> Integer.compare(c1.value, c2.value));

        while (m-- > 0) {
            for (Cell cell : cells) {
                Cell nextCell = getLargestNeighborCell(cell);

                // grid 갱신
                grid[cell.x][cell.y] = nextCell.value;
                grid[nextCell.x][nextCell.y] = cell.value;

                // cells 리스트 갱신
                int tempX = cell.x;
                int tempY = cell.y;
                cell.x = nextCell.x;
                cell.y = nextCell.y;
                nextCell.x = tempX;
                nextCell.y = tempY;
                cells.set(nextCell.value - 1, nextCell);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(grid[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

    public static Cell getLargestNeighborCell(Cell cell) {
        Cell nextCell = new Cell(-1, -1, 0);
        for (int d = 0; d < 8; d++) {
            int nextX = dx[d] + cell.x;
            int nextY = dy[d] + cell.y;
            if (!inRange(nextX, nextY)) continue;
            if (nextCell.value < grid[nextX][nextY]) {
                nextCell.x = nextX;
                nextCell.y = nextY;
                nextCell.value = grid[nextX][nextY];
            }
        }
        return nextCell;
    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}