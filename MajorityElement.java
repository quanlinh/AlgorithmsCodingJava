import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class MajorityElement {
    public static int getMajorityElement(int[] nums)
    {
        HashMap<Integer,Integer> mapDuplicate = new HashMap<>();
        int max = 0;
        for (int number: nums)
        {
            if(mapDuplicate.containsKey(number))
            {
                int value  = mapDuplicate.get(number) + 1;
                mapDuplicate.put(number,value);
                if(value > max) max = value;
            }
            else
            {
                mapDuplicate.put(number,1);
                if(max < 1) max = 1;
            }
        }
        if (max > nums.length/2) return 1;
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
     * @param nums
     * @return
     */
    public static int getMajorityElementStreamAlgorithmBoyer_Moored(int[] nums)
    {
        int size = nums.length;
        if(size < 2) return size;

        Integer candidate = null;
        int i = 0;
        for (int num:nums) {
            if(i == 0)
            {
                i++;
                candidate = num;
            } else if(candidate == num) i++;
            else i--;
        }

        int count = 0;
        for (int num: nums)
        {
            if(num == candidate) count++;
        }
        if(count > nums.length/2)return 1;
        else return 0;
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
