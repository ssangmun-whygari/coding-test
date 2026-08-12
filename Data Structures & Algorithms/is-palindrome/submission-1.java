class Solution {
    public boolean isPalindrome(String s) {
        int st = 0;
        int ed = s.length() - 1;

        boolean result = true;
        while (true) {
            while (st < s.length() && !Character.isLetterOrDigit(s.charAt(st))) {
                st++;
            }
            while (ed >= 0 && !Character.isLetterOrDigit(s.charAt(ed))) {
                ed--;
            }

            if (st > ed) break;

            if (Character.toLowerCase(s.charAt(st)) != Character.toLowerCase(s.charAt(ed))) {
                result = false;
                break;
            }
            st++; ed--;

            if (st > ed) break;
        }
        return result;
    }
}
