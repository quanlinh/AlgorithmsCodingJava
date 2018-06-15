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
