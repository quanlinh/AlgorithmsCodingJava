import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // on things to identify that the sum is not duplicate is
        // by using their index elelemnts. if ( we have for quadruplet)
        // we got to check all 4 index that wheter it if at least one different
        // with the exists index
        // brutal force O(n^4 )
        // sorted them it takes O(nlogn) time
        // we would take two loop, going number to tow numbers x & y & z
        // with 3 nested loop we looking for the fourth number that satisify
        // the sum and not equal to the index by binary search.
        // O(nlogn) + O(n) for x * O(n) for y * O(n) for z * (logNtime look up)
        // and constant check of index that not duplicate three order index constant
        // total running time would O(n^3logn)

        // If we not sorted them, we can use a hashtable that will stored
        // the index and the numbers
        // go through them x , y , z time and constant look up in hash
        // so we can achieve in O(n^3) time

        if (nums == null || nums.length < 4) return new ArrayList<>();
        HashMap<Integer, Integer> valueMapIndex = new HashMap<>();
        List<List<Integer>> fourSum = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            valueMapIndex.put(nums[i], i);
        }

        for (int x = 0; x < nums.length; x++) {
            for (int y = 1; y < nums.length; y++) {
                for (int z = 2; z < nums.length; z++) {
                    int key = target - (nums[x] + nums[y] + nums[z]);
                    if (valueMapIndex.containsKey(key)) {
                        int indexKey = valueMapIndex.get(key);
                        HashSet<Integer> fourIndex = new HashSet<>();
                        fourIndex.add(x);
                        fourIndex.add(y);
                        fourIndex.add(z);
                        fourIndex.add(indexKey);
                        if (fourIndex.size() == 4 && checkDuplicateIndex(valueMapIndex, fourSum, fourIndex)) {
                            ArrayList<Integer> sum = new ArrayList<>();
                            sum.add(nums[x]);
                            sum.add(nums[y]);
                            sum.add(nums[z]);
                            sum.add(nums[indexKey]);
                            fourSum.add(sum);
                        }
                    }
                }
            }
        }
        return fourSum;

    }

    private boolean checkDuplicateIndex(HashMap<Integer, Integer> valueMapIndex,
                                        List<List<Integer>> sumSoFar, HashSet<Integer> fourIndex) {
        for (List lst : sumSoFar) {
            System.out.println(lst.size() + "list size");
            System.out.println(fourIndex.size() + "four index size");
            for (Object value : lst) {

                System.out.println(valueMapIndex.get((Integer) value));
                fourIndex.add(valueMapIndex.get((Integer) value));
            }
            System.out.println(fourIndex.size() + "four index size");

            if (fourIndex.size() == 4) return false;
        }
        return true;
    }
}
