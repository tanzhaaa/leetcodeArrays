public class _26removeDuplicates {
    public static int removeDuplicates(int[] nums) {
        int len = 0;
        int i = 1;
        for(; i < nums.length; i++){
            if(nums[i] == nums[i - 1]){
                len++;
            }
            else{
                nums[i - len] = nums[i];
            }
        }
        System.out.println("i:"+i+",len:"+len);
        return i-len;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2};
        int len1 = removeDuplicates(nums);
        System.out.println(removeDuplicates(nums));
        for(int i = 0; i < len1; i++){
            System.out.print(nums[i]+",");
        }

        System.out.println(" ");
        int[] nums2 = new int[]{0,0,1,1,1,2,2,3,3,4};
        int len2 = removeDuplicates(nums2);
        System.out.println(removeDuplicates(nums2));
        for(int i = 0; i < len2; i++){
            System.out.print(nums2[i]+",");
        }

    }
}
