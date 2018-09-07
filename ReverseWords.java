import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Stack;


public class ReverseWords {

    public String reverseWords(String s) {
        if(s==null || s.equals("") || s.equals(" ")) return "";
        StringBuilder sb = new StringBuilder();
        char[] sChar  = s.toCharArray();
        int index = s.length() - 1;
        while(index > -1) {
            while(index > -1 && sChar[index] == 32) index--;
            Stack<Character> sWord = new Stack<>();
            while(index > -1 && s.charAt(index) != 32) {
                sWord.push(sChar[index--]);
            }
            while(!sWord.isEmpty()) sb.append(sWord.pop());
            while(index > 0 && sChar[index] == 32) {
                if(index == 1 && sChar[0] != 32) break;
                index--;
            }
            if(index > 0 ) sb.append(" ");
        }

        return sb.toString();
    }
}
