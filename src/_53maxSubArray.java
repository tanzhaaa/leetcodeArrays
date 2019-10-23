import java.util.Arrays;


//  分治法，时间复杂度O（n），优点是可以并行运算
public class _53maxSubArray {
    public static int maxSubArray(int[] nums) {
        return mergeCount(nums,0,nums.length)[2];
    }

    /**
     * @return 片段处理后的数组，依次为：左通最大值，右通最大值，局部最大值，总和
     * */
    private static int[] mergeCount(int[] nums,int leftIndex,int rightIndex) {
        int[] result = new int[4];
        if (rightIndex - leftIndex != 1) {
            //  >>>1 右移操作，相当于除以2
            int midIndex = (rightIndex + leftIndex) >>> 1;      //找到中间位置的点，学习了
            int[] resL = mergeCount(nums, leftIndex, midIndex);
            int[] resR = mergeCount(nums, midIndex, rightIndex);
            result[0] = Math.max(resL[0], resL[3] + resR[0]);
            result[1] = Math.max(resR[1], resL[1] + resR[3]);
            result[2] = Math.max(Math.max(resL[2], resR[2]), resL[1] + resR[0]);
            result[3] = resL[3] + resR[3];
            return result;
        }
        Arrays.fill(result,nums[leftIndex]);
        return result;
    }



    //动态规划,时间复杂度o(n)。 (单线程最优解)
    public int maxSubArray2(int[] nums) {
        int sum=0,max=Integer.MIN_VALUE;
        for (int num:nums) {
            sum = Math.max(0, sum);
            sum+=num;
            max=Math.max(max,sum);
        }
        return max;
    }




    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
        nums = new int[]{-2,1};
        System.out.println(maxSubArray(nums));
        nums = new int[]{-2,-1};
        System.out.println(maxSubArray(nums));
        nums = new int[]{-1,-2};
        System.out.println(maxSubArray(nums));



    }
}
