import java.util.Arrays;
import java.util.HashMap;

public class CheckPermutations {
    public boolean checkPermutationOfTwoString(String string1,String string2) {
        char[] strArray1 = string1.toCharArray();
        char[] strArray2 = string2.toCharArray();
        Arrays.sort(strArray1);
        Arrays.sort(strArray2);
        for (int i = 0; i < strArray1.length; i++) {
            if (strArray1[i] != strArray2[i]) return false;
        }
        return true;
    }

    /**
     * Using Hash Map is not very efficient
     *
     * @param string1
     * @param string2
     * @return
     */
    public boolean checkPermutationOfTwoStringUsingHashMap(String string1,String string2) {
        if (string1.length() != string2.length()) return false;
        HashMap<Character, Integer> permutationMap = new HashMap<>();
        for (int i = 0; i < string1.length(); i++) {
            permutationMap.put(string1.charAt(i),i);
        }
        for (int i = 0; i < string2.length(); i++) {
            if (permutationMap.containsKey(string2.charAt(i))) {
                permutationMap.remove(string2.charAt(i));
            }
        }
        return permutationMap.size() == 0;
    }

    public boolean checkPermutationUsingChar(String string1,String string2) {
        if (string1.length() != string2.length()) return false;
        int[] permuteArray = new int[128]; // assume Ascii characters
        for (int i = 0; i < string1.length(); i++) {
            permuteArray[string1.charAt(i)]++;
        }
        for(int i = 0; i < string2.length(); i++) {
            permuteArray[string2.charAt(i)]--;
            if(permuteArray[string2.charAt(i)] < 0) return false;
        }
        return true;
    }

}
