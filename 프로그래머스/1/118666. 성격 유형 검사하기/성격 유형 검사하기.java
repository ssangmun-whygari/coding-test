class Solution {
    public String solution(String[] survey, int[] choices) {
        int[] map = new int[128];
        
        int[] left = new int[] {-1, 3, 2, 1, 0, 0, 0, 0};
        int[] right = new int[] {-1, 0, 0, 0, 0, 1, 2, 3};
        
        int p = 0;
        for (String str : survey) {
            char lch = str.charAt(0);
            char rch = str.charAt(1);
            map[lch] += left[choices[p]];
            map[rch] += right[choices[p]];
            p++;
        }
        
        char[] left_ind = new char[] {'R', 'C', 'J', 'A'};
        char[] right_ind = new char[] {'T', 'F', 'M', 'N'};
        
        String ans = "";
        for (int i = 0; i < 4; i++) {
            if (map[left_ind[i]] > map[right_ind[i]]) {
                ans += left_ind[i];
            } else if (map[left_ind[i]] < map[right_ind[i]]) {
                ans += right_ind[i];
            } else {
                char ch = (char) (Math.min((int) left_ind[i], (int) right_ind[i]));
                ans += ch;
            }
        }
        
        return ans;
    }
}