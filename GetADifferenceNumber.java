import java.util.HashSet;

public class GetADifferenceNumber {
    /**
     * not allowed to change the array
     * @param nums
     * @return
     */
    public int getIndexOfSmallestNumber(int [] nums) {
        HashSet<Integer> set  = new HashSet<>();
        for(int num: nums) set.add(num);
        for(int i = 0;  i < nums.length; i++) {
            if(! set.contains(i)) return i;
        }
        return nums.length;
    }
    // TODO implement
    public int getIndexOfSmallestNumberInPlace(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
//            while ()
        }
        return -1;
    }


}
