import java.util.Arrays;

public class _16threeSumClosest_slow {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int minSum = 0;
        int sum;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = 1; j < nums.length - 1; j++) {
                for (int k = nums.length - 1; k > j; k--) {
                    sum = nums[i] + nums[j] + nums[k];
                    if (Math.abs(sum - target) < min) {
                        min = Math.abs(sum - target);
                        minSum = sum;
                    }
                }
            }
        }
        return minSum;
    }

    public static void main(String[] args) {
        int[] ls = new int[]{-1, 2, 1, -4};
        _16threeSumClosest_slow r = new _16threeSumClosest_slow();
        System.out.println(r.threeSumClosest(ls,1));
    }
}