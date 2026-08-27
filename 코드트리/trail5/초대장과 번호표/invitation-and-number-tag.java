import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());

        Map<Integer, Set<Integer>> group = new HashMap<>();
        Set<Integer> groupSet = new HashSet<>();
        for (int i = 1; i <= g; i++) {
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            group.put(i, new HashSet<Integer>());
            while (size-- > 0) {
                group.get(i).add(Integer.parseInt(st.nextToken()));
            }
            groupSet.add(i);
        }

        Set<Integer> invited = new HashSet<>();
        invited.add(1);
        int ans = 1;
        Set<Integer> temp = new HashSet<>();
        Set<Integer> deletedGroup = new HashSet<Integer>();
        while (true) {
            for (int i : groupSet) {
                // group.get(i) : 그룹
                for (int j : invited) {
                    if (group.get(i).contains(j)) {
                        group.get(i).remove(j);
                    }
                }
                if (group.get(i).size() == 1) {
                    for (int k : group.get(i)) { // 어차피 1개밖에 없음
                        temp.add(k);
                    }
                    group.remove(i); // 그룹 삭제
                    deletedGroup.add(i);
                }
            }

            for (int deleted : deletedGroup) {
                groupSet.remove(deleted);
            }
            deletedGroup.clear();

            invited.clear();
            if (temp.size() >= 1) {
                ans += temp.size();
                for (int i : temp)
                  invited.add(i);
                temp.clear();
            } else {
                break;
            }
        }

        System.out.print(ans);
    }
}