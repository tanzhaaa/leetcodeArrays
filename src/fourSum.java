import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class fourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int sum;
        List<List<Integer>> ls = new ArrayList<>();
        for(int i = 0; i < nums.length - 3; i++){
            if(i == 0 || nums[i] != nums[i-1]){     //跳过重复的点
                for(int j = i + 1; j < nums.length - 2; j++){
                    if(j == i + 1 || nums[j] != nums[j-1]){     //同上，跳过
                        int k = j + 1, l = nums.length - 1;
                        while(k < l ){
                            if(k == j + 1 || nums[k] != nums[k - 1]){
                                sum = nums[i] + nums[j] + nums[k] + nums[l];
                                if(sum == target){
                                    ls.add(Arrays.asList(nums[i],nums[j],nums[k],nums[l]));
                                    k++;
                                    l--;
                                }
                                else if(sum < target){
                                    while(k < l && nums[k] == nums[k + 1]) k++;
                                    k++;
                                }
                                else{
                                    while(k < l && nums[l] == nums[l - 1]) l--;
                                    l--;
                                }
                            }
                            else{
                                k++;
                            }
                        }
                    }
                }

            }
        }
        return ls;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
//        System.out.println(fourSum(nums,0));
        int[] nums2 = new int []{-1,0,-5,-2,-2,-4,0,1,-2};
        System.out.println(fourSum(nums2,-9));
//        int[] nums3 = new int []{-2,-2,-2,-2,-2,-2};
//        System.out.println(fourSum(nums3,-8));

    }
}
