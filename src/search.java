/*
* 本题难点在于while的判断表达式：
*   A && B 表达式中，先判断A是否成立，再判断B
* 所以当nums[i]越界时，i < nums.length作为B还没有执行，结果就是直接报错
* */

public class search {
    public static int search(int[] nums, int target) {
        int index = -1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > target){
                while( i < nums.length - 1 && nums[i] < nums[i + 1] )
                    i++;
            }
            else if(nums[i] == target){
                index = i;
                break;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{4,5,6,7,0,1,2};
        System.out.println(search(nums1,0));
        System.out.println(search(nums1,3));

        int[] nums2 = new int[]{1};
        System.out.println(search(nums2,0));

        int[] nums3 = new int[]{1,3};
        System.out.println(search(nums3,0));

        int[] nums4 = new int[]{3,1};
        System.out.println(search(nums4,0));

    }
}
