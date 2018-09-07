public class ConvertToTitleExcel {
    public String convertToTitle(int n) {
        StringBuilder title = new StringBuilder();
        while (n > 0) {
            int carry = n % 26;
            if(carry == 0) {
                title.append(carry+25 + 65);
                n-=26;
            } else {
                title.append((char)(carry-1 + 65));

            }
            n /= 26;
        }
        return title.reverse().toString();
    }

    public int titleToNumber(String s) {
        char[] digits = s.toCharArray();
        int sum = 0, base = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            sum += base * (digits[i] - 64);
            base *= 26;
        }
        return sum;
    }

}
