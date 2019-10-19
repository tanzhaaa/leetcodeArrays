public class _35searchInsert {
    public static int searchInsert(int[] nums, int target) {
        int index = 0;
        int i = 0;
        while(i < nums.length && nums[i] < target)
            i++;
        if(i == nums.length)
            index = nums.length;
        else if(nums[i] >= target)
            index = i;
        return index;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,6};
        System.out.println(searchInsert(nums,5));
        System.out.println(searchInsert(nums,2));
        System.out.println(searchInsert(nums,7));
        System.out.println(searchInsert(nums,0));

    }
}
