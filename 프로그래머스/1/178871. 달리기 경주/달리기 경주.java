import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }
        
        for (String str : callings) {
            int idx = map.get(str);
            // idx와 idx - 1에 있는 이름을 바꾼다.
            String temp = players[idx];
            players[idx] = players[idx - 1];
            players[idx - 1] = temp;
            // map을 갱신한다.
            map.put(str, idx - 1);
            map.put(players[idx], idx);
        }

        return players;
    }
}