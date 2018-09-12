import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class SortedStackByStackTest {
    @Test
    void testSortedStack() {
        SortedStackByStack sortedStackByStack = new SortedStackByStack();
        Stack<Integer> s1 = new Stack<>();

        s1.push(2);
        s1.push(0);
        s1.push(3);
        Stack<Integer> s1Expected = new Stack<>();
        s1Expected.push(3);
        s1Expected.push(2);
        s1Expected.push(0);
//        sortedStackByStack.sortedAStack(s1);
        sortedStackByStack.sortedAStackImprovement(s1);
        while (!s1Expected.isEmpty()) {
            assertEquals(s1Expected.pop(),s1.pop());
        }



    }
    @Test
    void testStupid()
    {
//        Stack<Character[][]> a = new Stack<>();
//        Character[][] x = new Character[1][1];
//        x[0][0] = '0';
//        x[0][1] = '1';
//        a.push(new char);
//        Character[][] b = a.peek();
//        HashSet<Character[][]> set = new HashSet<>();
//        set.add(new Character['1']['1']);
//        Character[][] c = new Character[1][2];
//        c[0][0] = '1';
//        c[0][1] = '1';
//        System.out.println(set.contains(c));
    }


}