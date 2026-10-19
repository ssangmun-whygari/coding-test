class Solution {
    public char left = '*';
    public char right = '#';
    
    public char[][] pad = new char[][] {
        {'1', '2', '3'},
        {'4', '5', '6'},
        {'7', '8', '9'},
        {'*', '0', '#'}
    };
    
    public String solution(int[] numbers, String hand) {
        // 1, 4, 7 : 왼손 / 3, 6, 9 : 오른손
        
        // 1, 2, 3
        // 4, 5, 6
        // 7, 8, 9
        // *, 0, #
        
        StringBuilder sb = new StringBuilder();
        // System.out.println("left : " + left + ", right : " + right);
        for (int i : numbers) {
            int result = process((char) (i + '0'), hand);
            // System.out.println("left : " + left + ", right : " + right);
            sb.append(result == 0 ? 'L' : 'R');
        }
        return sb.toString();
    }
    
    public int process(char ch, String hand) {
        int result = 0;
        int x = ch - '0';
        if (x == 1 || x == 4 || x == 7) {
            left = ch;
        } else if (x == 3 || x == 6 || x == 9) {
            right = ch;
            result = 1;
        } else { // 2, 5, 8, 0
            int leftDist = getDist(left, ch);
            int rightDist = getDist(right, ch);
            if (leftDist == rightDist) {
                if ("right".equals(hand)) {
                    right = ch;
                    result = 1;
                } else {
                    left = ch;
                }
            } else if (leftDist < rightDist) {
                left = ch;
            } else {
                right = ch;
                result = 1;
            }
        }
        return result;
    }
    
    public int getDist(char a, char b) {
        int ax = 0, ay = 0, bx = 0, by = 0;
        for (int x = 0; x < pad.length; x++) {
            for (int y = 0; y < pad[0].length; y++) {
                if (pad[x][y] == a) {
                    ax = x; ay = y;
                }
                if (pad[x][y] == b) {
                    bx = x; by = y;
                }
            }
        }
        return Math.abs(ax - bx) + Math.abs(ay - by);
    }
    
}