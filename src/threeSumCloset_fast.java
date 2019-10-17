import java.util.Arrays;

/*
* 先排序，然后进行遍历
* 内部使用双指针，
* 外层for循环
* 内层while循环
* 时间复杂度为 O（n^2）
* */
public class threeSumCloset_fast {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int minSum = 0;
        int sum;
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1, k = nums.length - 1;
            while(j < k){
                sum = nums[i] + nums[j] + nums[k];

                if(sum == target){
                    return target;
                }
                else if(sum < target){
                    j++;
                }
                else
                    k--;
                if (Math.abs(sum - target) < min) {
                    min = Math.abs(sum - target);
                    minSum = sum;
                }
            }
        }
        return minSum;
    }

    public static void main(String[] args) {
        int[] ls = new int[]{-1, 2, 1, -4};
        threeSumCloset_fast r = new threeSumCloset_fast();
        System.out.println(r.threeSumClosest(ls,1));
    }
}
