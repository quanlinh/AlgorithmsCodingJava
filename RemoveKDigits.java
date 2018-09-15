public class RemoveKDigits {
    public String removeKDigits(String num, int k) {
        if (num.length() == k) return "0";
        int numToChose = num.length() - k;
        StringBuilder sb = new StringBuilder();
        int numToChoseIndex = 0;
        while (numToChose > 0) {
            char min = num.charAt(numToChoseIndex);
            for (int i = numToChoseIndex + 1; i <= num.length() - numToChose; i++) {
                if (num.charAt(i) < min) {
                    min = num.charAt(i);
                    numToChoseIndex = i;
                }
            }
            sb.append(min);
            numToChose--;
            numToChoseIndex++;
        }
        String results = sb.toString();
        int zeroIndex = 0;
        while (zeroIndex < results.length() - 1 && results.charAt(zeroIndex) == '0') {
            zeroIndex++;
        }

        return results.substring(zeroIndex);
    }

    public String buildTheLowestNumber(String num, int k) {
        int remain = num.length() - k;
        char[] digits = new char[num.length()];
        int top = 0;
        for (char c : num.toCharArray()) {
            while (k > 0 && top > 0 && digits[top - 1] > c) {
                top--;
                k--;

            }
            digits[top++] = c;
        }
        int zeroIndex = 0;
        while (zeroIndex < remain && digits[zeroIndex] == '0') zeroIndex++;
        StringBuilder sb = new StringBuilder();
        if (zeroIndex == remain) return "0";
        else {
            while (zeroIndex < remain) {
                sb.append(digits[zeroIndex++]);
            }
        }
        return sb.toString();
    }
}
