import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class MajorityElement {
    public static int getMajorityElement(int[] nums) {
        HashMap<Integer, Integer> mapDuplicate = new HashMap<>();
        int max = 0;
        for (int number : nums) {
            if (mapDuplicate.containsKey(number)) {
                int value = mapDuplicate.get(number) + 1;
                mapDuplicate.put(number, value);
                if (value > max) max = value;
            } else {
                mapDuplicate.put(number, 1);
                if (max < 1) max = 1;
            }
        }
        if (max > nums.length / 2) return 1;
        else return 0;
    }
    // Pseudo Code

    /**
     * Initialize an element m and a counter i with i = 0
     * For each element x of the input sequence
     * -> If i = 0, then assign m = x and i = 1
     * -> Else if m = x, then assign i = i + 1
     * -> Else assign i = i - 1
     * Return m
     *
     * @param nums
     * @return
     */
    public static int getMajorityElementStreamAlgorithmBoyer_Moored(int[] nums) {
        int size = nums.length;
        if (size < 2) return size;

        Integer candidate = null;
        int i = 0;
        for (int num : nums) {
            if (i == 0) {
                i++;
                candidate = num;
            } else if (candidate == num) i++;
            else i--;
        }

        int count = 0;
        for (int num : nums) {
            if (num == candidate) count++;
        }
        if (count > nums.length / 2) return 1;
        else return 0;
    }

    /**
     * if a sequence of length n contains a majority elements, it is true for it halves
     * This is true based on the pigeon hole principle
     *
     * @param nums
     * @return
     */
    public static int getMajorityElementAlgorithmDivideAndConquer(int[] nums) {
        // base cases
        if(nums == null || nums.length == 0 ) return 0;
        if(nums.length == 1) return 1;
        int isMajor =  getMajorityElementAlgorithmDivideAndConquer(nums,0,nums.length-1);
        int count = count(nums,isMajor);
        if(count > nums.length/2) return 1;
        else return 0;
    }

    /**
     * There are three cases:
     * case1: They have the same major element
     * case2: If one parts have majority element, count in both part: one parts have numbers, one part is null
     * case3: If both parts have major, have to count each of them and compare with one is greater
     * case4: If both of them have no major pick either one
     */

    private static int getMajorityElementAlgorithmDivideAndConquer(int[] nums, int lo, int hi) {
        // base case: if it has only one element, that element must be major
        if (lo == hi) return nums[lo];
        int mid = (lo + hi) / 2;
        int leftMajor = getMajorityElementAlgorithmDivideAndConquer(nums,lo,mid);
        int rightMajor = getMajorityElementAlgorithmDivideAndConquer(nums,mid+1,hi);
        if( leftMajor == rightMajor) return leftMajor;
        int countLeft = countRange(nums, leftMajor, lo, mid);
        int countRight = countRange(nums, rightMajor, mid + 1, hi);
        if(countLeft > countRight) return leftMajor;
        else return rightMajor;
    }

    public static int getMajorityElementBysorting(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        randomizedQuickSorted randomizedQuickSorted = new randomizedQuickSorted();
        randomizedQuickSorted.quickSorted(nums);
        if (nums[nums.length / 2] == nums[0]) return 1;
        else return 0;
    }

    public static int countRange(int[] nums, int key, int lo , int hi)
    {
        int count = 0;
        for(int i = lo; i <= hi; i++) if(nums[i] == key) count++;
        return count;
    }
    public static  int count(int[] nums, int key) {
        int count = 0;
        for (int num : nums) if (num == key) count++;
        return count;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(getMajorityElement(a));
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

}
