import java.util.HashMap;

public class CheckIfAStringIsPermutationOfPalindrome {
    public boolean isThisStringAPermutationOfAPanlindrome(String s) {
        HashMap<Character, Integer> perMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char w = Character.toLowerCase(s.charAt(i));
            if (w == ' ') continue;
            if (perMap.containsKey(w)) {
                int repeat = perMap.get(w);
                repeat--;
                if (repeat == 0) perMap.remove(w);
                else {
                    perMap.put(w,repeat);
                }
            } else {
                perMap.put(w,1);
            }
        }
        System.err.println(perMap.size());
        return perMap.size() == 1 || perMap.size() == 0;
    }

    public boolean isPalindrome(String s) {
        int leftPointer = 0;
        int rightPointer = s.length() - 1;
        int even = 0;
        while (leftPointer <= rightPointer) {
            char charOnLeft = Character.toLowerCase(s.charAt(leftPointer));
            if (!((charOnLeft >= 48 && charOnLeft <= 57) || (charOnLeft >= 97 && charOnLeft <= 122))) {
                leftPointer++;
                continue;
            }
            char charOnRight = Character.toLowerCase(s.charAt(rightPointer));
            if (!((charOnRight >= 48 && charOnRight <= 57) || (charOnRight >= 97 && charOnRight <= 122))) {
                rightPointer--;
                continue;
            }
            if (charOnLeft == charOnRight) {
                leftPointer++;
                rightPointer--;
                even += 2;
                // TODO FIXED THE BUGS WITH INPUT LIKE THIS "AA2baa" or "aaa2bAAA"
                // It get to a point that the string is obvious not palindrome but return right
            } else return leftPointer + 1 == rightPointer && (even % 2) != 0;
        }
        return true;
    }
}
