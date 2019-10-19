import java.util.Arrays;
/*
* 在所有需要判断 i < nums.length 的地方，必须要把它放在第一个判断的位置！！
* */


public class _34searchRanges {
    public static int[] searchRange(int[] nums, int target) {
        int start = -1, end = -1;
        for(int i = 0; i < nums.length && nums[i] <= target ; i++ ){
            while(i < nums.length && nums[i] <target)
                i++;
            if(i < nums.length && nums[i] == target){
                start = i;
                while(i < nums.length && nums[i] == target)
                    i++;
                end = i - 1;
                break;
            }
        }
        return new int[]{start,end};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,7,7,8,8,10};
        System.out.println(Arrays.toString(searchRange(nums,8)));
        System.out.println(Arrays.toString(searchRange(nums,6)));
    }
}

