import java.util.ArrayList;
import java.util.Stack;

public class StringRotation {
    public boolean rotateString(String A,String B) {
//        if (A.length() != B.length()) return false;
//        int lenA = A.length();
//        int j = 0;
//        ArrayList<Character> storeChar = new ArrayList<>();
//        for (int i = 0; i < lenA-1; i++) {
//            char charA = A.charAt(i);
//            System.out.println(charA);
//            while (j < lenA && charA != B.charAt(j) ) {
//                storeChar.add(B.charAt(j++));
//                if (j == lenA) {
//                    System.out.println("false at first loop ? ");
//                    return false;
//                } // not found
//            }
//            if (j < lenA) {
//                System.out.println(" brooks were here");
//                System.out.println(charA + " " + B.charAt(j));
//                if (charA != B.charAt(j++)) {
//                    System.out.println("false at j < lenA loop ? ");
//                    return false;
//                }
//            }
//            if (j == lenA) {
//                char charBNew = storeChar.remove(0);
//                System.out.println(A.charAt(i+1) + " vs " + charBNew);
//                if (A.charAt(i+1) != charBNew) {
//                    System.out.println("false at last comparision ? ");
//                    return false;
//                }
//            }
//        }
//        int i = 0;
//        while (i < lenA) {
//            if (A.charAt(0) == B.charAt(i++)) {
//                if (i == lenA) break;
//                if(i < lenA && A.charAt(1) == B.charAt(i)) break;
//            }
//        }
//        if (i == lenA) return false;
//        int j = 1;
//        int distance = lenA - i;
//        while (j <= (distance)) {
//            if (A.charAt(j++) != B.charAt(i++)) return false;
//        }
//        int k = 0;
//        while (j < lenA) {
//            if (A.charAt(j++) != B.charAt(k++)) return false;
//        }
//
//
//        return true;
        return A.length() == B.length() && (A + A).contains(B);

    }
}
