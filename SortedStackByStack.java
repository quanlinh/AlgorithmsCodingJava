import java.util.ArrayList;
import java.util.Stack;

public class SortedStackByStack {
    public void sortedAStack(Stack<Integer> stackToSorted) {
        int size = stackToSorted.size();
        Stack<Integer> sortedStack = new Stack<>();
        int elementIsSorted = 0;
        while (elementIsSorted < size - 1) {
            int maxNumber = stackToSorted.pop();
            while (stackToSorted.size() > elementIsSorted) {
                int val = stackToSorted.pop();
                if (val > maxNumber) {
                    sortedStack.push(maxNumber);
                    maxNumber = val;
                } else {
                    sortedStack.push(val);
                }
            }
            stackToSorted.push(maxNumber);
            elementIsSorted++;
            while (!sortedStack.isEmpty()) {
                stackToSorted.push(sortedStack.pop());
            }
        }
    }

    public void sortedAStackImprovement(Stack<Integer> stackToSorted) {
        Stack<Integer> sortedStack = new Stack<>();
        while (!stackToSorted.isEmpty()) {
            int val = stackToSorted.pop();
            while (!sortedStack.isEmpty() && sortedStack.peek() > val) {
                stackToSorted.push(sortedStack.pop());
            }
            sortedStack.push(val);
        }
        while (!sortedStack.isEmpty()) {
            stackToSorted.push(sortedStack.pop());
        }
    }
}
