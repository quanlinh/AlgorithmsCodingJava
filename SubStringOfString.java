public class SubStringOfString {
    public int strStr(String haystack, String needle) {
        if (needle.equals("") || (haystack.equals(needle))) return 0;
        char[] haystackChar = haystack.toCharArray();
        char[] needleChar = needle.toCharArray();
        int lenHaystack = haystack.length(), lenNeedle = needle.length();
        int haystackIndex = lenHaystack - 1, needleIndex = lenNeedle - 1;
        while (haystackIndex > -1 && needleIndex > -1) {
            while (haystackIndex > -1 && needleIndex > -1 && needleChar[needleIndex] != haystackChar[haystackIndex])
                haystackIndex--;
            if (haystackIndex >= lenHaystack) return -1;
            int index = haystackIndex;
            while (haystackIndex > -1 && needleIndex > -1 && needleChar[needleIndex] == haystackChar[haystackIndex]) {
                haystackIndex--;
                needleIndex--;
            }
            while(haystackIndex > -1 && needleIndex == -1 && needleChar[needleIndex+1] == haystackChar[haystackIndex]) haystackIndex--;

            if (needleIndex == -1) return haystackIndex+1;
            else {
                needleIndex = lenNeedle - 1;
            }


        }
        return -1;

    }
}
