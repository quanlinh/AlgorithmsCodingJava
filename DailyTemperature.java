import java.util.Stack;

public class DailyTemperature {

    public int[] dailyTemperaturesTooSlowVersion(int[] T) {
        int[] warmer = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            Stack<Integer> mem = new Stack<>();
            for (int j = i + 1; j < T.length; j++) {
                if (warmer[i] != 0) continue;
                if (T[i] < T[j]) {
                    warmer[i] = j - i;
                    break;
                } else {
                    if (mem.isEmpty() || mem.peek() > T[j]) {
                        mem.push(T[j]);
                    } else {
                        while (!mem.isEmpty() && mem.peek() < T[j]) {
                            int k = j;
                            while (T[k] != mem.peek()) k--;
                            warmer[k] = j - k;
                            mem.pop();
                        }
                    }
                }
            }
        }
        return warmer;
    }

    public int[] dailyTemperaturesBrtualForce(int[] T) {
        // HashTable
        // Sorting // cannot
        // Heap ?
        // double loop
        // Tree?

        // we got to use an array to keep track of temperature? then back tracking
        // T = [73, 74, 75, 71, 69, 72, 76, 73]
        //T1 = [73,74,75,71,69,72,76,0]
        // go through the array, t las element always 0
        // the n-2 element is 0 if is greater than n-1 ; 1 if less than
        // keep the min 72  < 73 so it is 1
        // min is 72
        //

        int[] res = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            int count = 0;
            int val = T[i];
            boolean found = false;
            for (int j = i + 1; j < T.length; j++) {
                count++;
                if (T[i] < T[j]) {
                    found = true;
                    break;
                }
            }
            if (found) res[i] = count;

        }
        return res;

    }

    public int[] dailyTemperaturesStackOptimize(int[] T) {
        // Time Complexity will O(2N) ~ O(N), space will be O(N) for stack store
        int[] warmer = new int[T.length];
        Stack<Integer> stackIndex = new Stack<>();
        for (int i = T.length - 1; i > -1; i--) {
            int currTemp = T[i];
            while (!stackIndex.isEmpty() && currTemp >= T[stackIndex.peek()]) {
                stackIndex.pop();
            }
            if (!stackIndex.isEmpty()) {
                warmer[i] = stackIndex.peek() - i;
            }
            stackIndex.push(i);
        }
        return warmer;
    }
}
