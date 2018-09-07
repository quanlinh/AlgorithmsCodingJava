import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PermutationObjects {
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) return new ArrayList<>();
        ArrayList<List<Integer>> listPermute = new ArrayList<>();
//            for(int i = 0; i < nums.length; i++) {
//                int[] temp = Arrays.copyOf(nums,nums.length);
//                if(i != 0) {
//                    temp[0] = nums[i];
//                    temp[i] = nums[0];
//                }
//                ArrayList<Integer> val = new ArrayList<>();
//                for(int k = 0; k < temp.length; k++) val.add(temp[k]);
//                listPermute.add(val);
//                for(int j = 1; j < temp.length-1; j++) {
//                    int tempInt = temp[j+1];
//                    temp[j+1] = temp[j];
//                    temp[j] = tempInt;
//                    ArrayList<Integer> val2 = new ArrayList<>();
//                    for(int k = 0; k < temp.length; k++) val2.add(temp[k]);
//                    listPermute.add(val2);
//
//                }
//            }
        permutation1(nums, nums.length, listPermute);

        return listPermute;
    }

    public void permutation1(int[] a, int n, ArrayList<List<Integer>> listPermute) {
        if (n == 1) {
            System.out.println(Arrays.toString(a));
            ArrayList<Integer> val = new ArrayList<>();
            for (int k = 0; k < a.length; k++) val.add(a[k]);
            listPermute.add(val);
            return;
        }
        for (int i = 0; i < n; i++) {
            int temp = a[i];
            a[i] = a[n - 1];
            a[n - 1] = temp;
            // (remove the ith element)
            permutation1(a, n - 1, listPermute);
            temp = a[i];
            a[i] = a[n - 1];
            a[n - 1] = temp;
        }
    }

    public void heapPermutation(int[] a, int n, ArrayList<List<Integer>> listPermute) {
        if (n == 1) {
            ArrayList<Integer> val = new ArrayList<>();
            for (int k = 0; k < a.length; k++) val.add(a[k]);
            listPermute.add(val);
            return;
        }
        for (int i = 0; i < n; i++) {
            heapPermutation(a, n - 1, listPermute);
            // always swap the first when odd
            // swap ith position when even
            if (n % 2 == 0) {
                int temp = a[i];
                a[i] = a[n - 1];
                a[n - 1] = temp;
            } else {
                int temp = a[0];
                a[0] = a[n - 1];
                a[n - 1] = temp;
            }

             HashMap<HashMap<Integer,Integer>,Integer> cache; // key value pair, and numbers using cache

        }
    }


}
