import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        int n = 26 - skip.length();
        char[] arr = new char[n];
        makeArr(arr, skip);
        
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            int newIdx = (map.get(ch) + index) % n;
            sb.append(arr[newIdx]);
        }
        
        return sb.toString();
    }
    
    public void makeArr(char[] arr, String skip) {
        Set<Character> set = new HashSet<>();
        for (Character ch : skip.toCharArray()) {
            set.add(ch);
        }
        
        int j = 0;
        for (int i = 0; i < 26; i++) {
            char ch = (char) ('a' + i);
            if (!set.contains(ch)) {
                arr[j++] = ch;
            }
        }
    }
}