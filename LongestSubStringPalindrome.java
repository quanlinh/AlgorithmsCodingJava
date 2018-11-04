public class LongestSubStringPalindrome {
    // "babad"
    // "bab" is a palindrome
    // "bab" is a palindrome
    // "baba" is not
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for(int center = 0; center < s.length(); center ++) {
            int oddPalindrome = lenPalindromeFromCenter(s, center, center);
            int evenPalindrome = lenPalindromeFromCenter(s,center, center+1);
            int len = Math.max(oddPalindrome, evenPalindrome);
            if(len > end - start + 1) {
                start = center - (len - 1) / 2;
                end   = center + (len    ) / 2;
            }
        }
        return s.substring(start, end + 1);
    }
    private  int lenPalindromeFromCenter(String s, int left, int right) {
        int L = left, R = right;
        while(L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}
