import java.util.*;

class Solution {
    class Robot {
        public int id, x, y;
        public int nextDest = 1;
        Robot(int id, int x, int y) {
            this.id = id;
            this.x = x;
            this.y = y;
        }
        
        @Override
        public String toString() {
            return "[Robot id: " + id + ", x: " + x + ", y: " + y + "]";
        }
    }
    
    class Pair {
        public int x;
        public int y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        @Override
        public boolean equals(Object o) {
            if (o == null) return false;
            if ( !(o instanceof Pair)) return false;
            Pair other = (Pair) o;
            if (this.x == other.x && this.y == other.y) {
                return true;
            } else {
                return false;
            }
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
    
    public Set<Pair> set = new HashSet<>();
    public int[][] grid = new int[100][100];
    public int answer = 0;
    public Robot[] robots;
    
    public int solution(int[][] points, int[][] routes) {
        
        robots = new Robot[routes.length];
        for (int i = 0; i < routes.length; i++) {
            int startNum = routes[i][0] - 1; // i번 로봇의 출발점 번호
            int destNum = routes[i][1] - 1;
            robots[i] = new Robot(i, points[startNum][0] - 1, points[startNum][1] - 1);
            grid[robots[i].x][robots[i].y] += 1;
        }
        
        // 충돌 위험 체크
        set.clear();
        for (int i = 0; i < robots.length; i++) {
            set.add(new Pair(robots[i].x, robots[i].y));
        }
        for (Pair coord : set) {
            if (grid[coord.x][coord.y] >= 2) {
                answer += 1;
            }
        }
        
        Queue<Robot> queue = new ArrayDeque<>();
        for (Robot robot : robots) {
            queue.add(robot);
        }
        while (!queue.isEmpty()) {
            simulate(queue, points, routes);
        }
        
        return answer;
    }
    
    public void simulate(Queue<Robot> queue, int[][] points, int[][] routes) {
        set.clear();
        Queue<Robot> temp = new ArrayDeque<>();
        // System.out.println(queue);
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            Robot cur = queue.poll();
            
            int destId = routes[cur.id][cur.nextDest] - 1; // 지금 로봇의 다음 목적지 번호
            int destX = points[destId][0] - 1;
            int destY = points[destId][1] - 1;
            
            // 현재 로봇 이동하기
            grid[cur.x][cur.y] -= 1; // grid에서 이동
            Pair vec = getVec(cur, destX, destY);
            cur.x += vec.x;
            cur.y += vec.y;
            grid[cur.x][cur.y] += 1;
            set.add(new Pair(cur.x, cur.y));
            
            if (cur.x != destX || cur.y != destY) {
                queue.add(cur);
            } else { // 목적지에 도달했다면
                if (cur.nextDest + 1 < routes[0].length) { // 다음에 갈 수 있는 목적지가 있다면
                    cur.nextDest += 1;
                    queue.add(cur);
                } else {
                    temp.add(cur);
                }
            }
        }
        
        // 충돌 위험 횟수 계산
        for (Pair coord : set) {
            if (grid[coord.x][coord.y] >= 2) {
                // System.out.println("x : " + coord.x + ", y : " + coord.y);
                answer += 1;
            }
        }
        
        // 목적지에 도착한 로봇을 그리드에서 삭제
        while (!temp.isEmpty()) {
            Robot p = temp.poll();
            grid[p.x][p.y] -= 1;
        }
    }
    
    public Pair getVec(Robot cur, int destX, int destY) {
        Pair vec = new Pair(0, 0);
        if (cur.x < destX) {
            vec.x = 1;
        } else if (cur.x > destX) {
            vec.x = -1;
        } else if (cur.y < destY) {
            vec.y = 1;
        } else if (cur.y > destY) {
            vec.y = -1;
        }
        return vec;
    }
}