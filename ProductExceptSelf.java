public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        for (int n : nums) product *= n;
        int[] m = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) m[i] = 0;
            else m[i] = product / nums[i];
        }
        return m;
    }
}
