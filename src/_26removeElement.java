import java.util.Arrays;

public class _26removeElement {
    public static int removeElement(int[] nums, int val) {
        int i = 0;
        int count = 0;
        for(; i < nums.length; i++){
            if(nums[i] == val)
                count ++;
            else if(count != 0)
                nums[i - count] = nums[i];
        }
        return i - count;
    }

    public static void main(String[] args) {
//         int[] nums1 = new int[]{3,2,2,3};
//         System.out.println(removeElement(nums1,2));
        int[] nums2 = new int[]{0,1,2,2,3,0,4,2};
        System.out.println(removeElement(nums2,2));

    }
}
