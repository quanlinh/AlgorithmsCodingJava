public class RomanToInteger {
    public int romanToInt(String s) {
        char[] digits = s.toCharArray();
        int size = digits.length;
        int i = 0, sum = 0;
        while (i < size) {
            if (digits[i] == 'I') {
                if (i + 1 < size && digits[i + 1] == 'V') {
                    sum += 4;
                    i++;
                } else if (i + 1 < size && digits[i + 1] == 'X') {
                    sum += 9;
                    i++;
                } else sum += 1;
            } else if (digits[i] == 'X') {
                if (i + 1 < size && digits[i + 1] == 'L') {
                    sum += 40;
                    i++;
                } else if (i + 1 < size && digits[i + 1] == 'C') {
                    sum += 90;
                    i++;
                } else sum += 10;
            } else if (digits[i] == 'C') {
                if (i + 1 < size && digits[i + 1] == 'D') {
                    sum += 400;
                    i++;
                } else if (i + 1 < size && digits[i + 1] == 'M') {
                    sum += 900;
                    i++;
                } else sum += 100;
            } else if (digits[i] == 'V') sum += 5;
            else if (digits[i] == 'L') sum += 50;
            else if (digits[i] == 'D') sum += 500;
            else if (digits[i] == 'M') sum += 1000;
            i++;
        }
        return sum;
    }

    public int romanToIntImprove(String s) {
        if (s == null || s.length() == 0)
            return 0;

        int[] hash = new int[26];

        hash['I' - 'A'] = 1;
        hash['V' - 'A'] = 5;
        hash['X' - 'A'] = 10;
        hash['L' - 'A'] = 50;
        hash['C' - 'A'] = 100;
        hash['D' - 'A'] = 500;
        hash['M' - 'A'] = 1000;

        int prev = Integer.MIN_VALUE;
        int roman = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int dig = hash[s.charAt(i) - 'A'];

            if (dig < prev)
                roman -= dig;
            else
                roman += dig;

            prev = dig;
        }

        return roman;
    }
}
