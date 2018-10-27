public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i > -1 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i > -1) {
            int j = nums.length - 1;
            while (j > -1) {
                if (nums[i] < nums[j]) {
                    swap(nums,i,j);
                    break;
                }
                j--;
            }
        }
        reverse(nums,i + 1);
    }

    private void swap(int[] nums,int left,int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    private void reverse(int[] nums,int pos) {
        int left = pos, right = nums.length - 1;
        while (left < right) {
            swap(nums,left,right);
            left++;
            right--;
        }
    }
}
