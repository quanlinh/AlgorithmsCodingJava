public class MaximumSubsequenceTwoDistinctCharacter {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s.length() < 3) return s.length();
        int max = 0;
        char firstChar, secondChar;
        for (int i  = 0; i < s.length() && max < s.length() - i; i++) {
            firstChar = s.charAt(i);
            int j = i + 1;
            while(j < s.length() && s.charAt(j) == firstChar) {
                j++;
            }
            if(j == s.length()) {
                return Math.max(max,j-i);
            } else {
                secondChar = s.charAt(j);
                while(j < s.length() && (s.charAt(j) == firstChar || s.charAt(j) == secondChar)) {
                    j++;
                }
                max = Math.max(max,j-i);
            }
        }
        return max;
    }
}
