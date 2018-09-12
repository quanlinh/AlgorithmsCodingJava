public class StringCompression {
    public String stringCompresssion(String s) {
        if (s.length() == 0 || s.length() == 1) return s;
        StringBuilder stringBuilder = new StringBuilder();
        int repeated = 1;
        boolean isComp = false;
        for (int i = 0; i < s.length() - 1; i++) {
            char c = s.charAt(i);
            char cNext = s.charAt(i + 1);
            if (c == cNext) {
                repeated++;
                isComp = true;
                if (i + 1 == s.length() - 1) {
                    stringBuilder.append(c);
                    stringBuilder.append(repeated);
                }
            } else {
                stringBuilder.append(c);
                stringBuilder.append(repeated);
                repeated = 1;
                if (i + 1 == s.length() - 1) {
                    stringBuilder.append(cNext);
                    stringBuilder.append(repeated);
                }
            }
        }
        if (isComp) {
            return stringBuilder.toString();
        } else {
            return s;
        }
    }
}
