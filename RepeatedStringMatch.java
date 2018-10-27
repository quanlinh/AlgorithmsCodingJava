public class RepeatedStringMatch {
    public int repeatedStringMatch(String A, String B) {
        int[] charMap = new int[128];
        for(char c : A.toCharArray()) {
            charMap[c]++;
        }
        for(char c: B.toCharArray()) {
            if(charMap[c] == 0) return -1;
        }

        int count = 1;
        String repeated = new String(A);
        while(!repeated.contains(B)) {
           repeated += A;
            count++;
        }
        return count;
    }
}
