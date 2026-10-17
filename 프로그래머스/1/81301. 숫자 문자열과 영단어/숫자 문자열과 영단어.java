class Solution {
    public int solution(String s) {
        String[] map = new String[] {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        
        for (int i = 0; i < map.length; i++) {
            s = s.replace(map[i], String.valueOf(i));
        }
        
        return Integer.parseInt(s);
    }
}