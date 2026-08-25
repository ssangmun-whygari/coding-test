import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String p = sc.next();
        
        List<String> regex = new ArrayList<>();
        for (int i = 0; i < p.length(); i++) {
            if (isAlphabet(p.charAt(i)) || p.charAt(i) == '.') {
                if (i != p.length() - 1 && p.charAt(i + 1) == '*') {
                    regex.add(p.substring(i, i + 2));
                } else {
                    regex.add(p.substring(i, i + 1));
                }
            }
        }

        // boolean[][] dp = new boolean[regex.size()][s.length() + 2];
        boolean[][] dp = new boolean[regex.size()][23];

        for (int j = 0; j < dp[0].length; j++) {
            if (j == 0) {
                dp[0][0] = regex.get(0).length() == 1 ? false : true;
            } else if (j == 1) {
                char ch = regex.get(0).charAt(0);
                if (isAlphabet(ch) && ch == s.charAt(0)) {
                    dp[0][j] = true;
                } else if (ch == '.') {
                    dp[0][j] = true;
                } else {
                    dp[0][j] = false;
                }
            } else if (j <= s.length()) { // j >= 2
                dp[0][j] = match(s.substring(0, j), regex.get(0));
            } else {
                dp[0][j] = match(s, regex.get(0));
            }
        }

        // System.out.println(Arrays.toString(dp[0]));
        for (int i = 1; i < regex.size(); i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (j == 0) { // 매칭시키는 문자열이 ""(아무것도 없음)일때
                    if (dp[i - 1][0] == false) {
                        dp[i][0] = false;
                    } else if (regex.get(i).matches(".\\*")) {
                        dp[i][0] = true;
                    } else {
                        dp[i][0] = false;
                    }
                } else {
                    boolean result = false;
                    for (int k = 0; k < j; k++) {
                        if (dp[i - 1][k] == true) {
                            String substr = s.substring(Math.min(k, s.length()) , Math.min(j, s.length()));
                            result = match(substr, regex.get(i));
                            if (result == true) break;
                        }
                    }
                    dp[i][j] = result;
                }
            }
        }

        // for (int i = 0; i < regex.size(); i++) {
        //     System.out.println(Arrays.toString(dp[i]));
        // }

        System.out.print(dp[regex.size() - 1][22]);

    }

    public static boolean match(String str, String re) {
        char ch = re.charAt(0);
        if (re.length() == 1) {
            if (str.length() != 1) return false;
            if (re.equals(str) || re.equals(".")) {
                return true;
            } else {
                return false;
            }
        } else {
            if (re.charAt(1) != '*')
                throw new RuntimeException("뭔가 잘못됨");
            if (str.length() >= 1) {
              for (int i = 0; i < str.length(); i++) {
                  if (isAlphabet(ch)) {
                      if (ch != str.charAt(i)) return false;
                  }
              }
            } else { // str이 공백인 경우
              return true;
            }
            return true;
        }
    }

    public static boolean isAlphabet(char ch) {
        return ch - 'a' >= 0 && 'z' - ch >= 0;
    }
}