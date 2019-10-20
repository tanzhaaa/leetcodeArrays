import java.util.Arrays;

/*
* 本题提供两种完全不同的解法
* */

public class _41firstMissingPositive {
    public static int firstMissingPositive1(int[] nums) {
        for (int i = 1; ; i++) {
            boolean flag = false;
            for (int num : nums) {
                if (num == i) {
                    flag = true;
                    break;
                }
            }
            if(!flag)
                return i;

        }
    }

    public int firstMissingPositive2(int[] nums) {
        boolean[] inNums = new boolean[1000];
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                if(nums[i] > 999)
                    nums[i] = 999;
                inNums[nums[i] - 1] = true;
            }
        }
        int j = 0;
        while(inNums[j])
            j++;
        return j + 1;
    }


    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,0};
        System.out.println(firstMissingPositive1(nums1));

        int[] nums2 = new int[]{3,4,-1,1};
        System.out.println(firstMissingPositive1(nums2));

        int[] nums3 = new int[]{7,8,9};
        System.out.println(firstMissingPositive1(nums3));

        int[] nums4 = new int[]{1024};
        System.out.println(firstMissingPositive1(nums4));
    }
}
