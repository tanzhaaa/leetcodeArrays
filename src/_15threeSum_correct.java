import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* 本题重点在于：
* 1.Arrays的操作不熟悉
* 2.没有想到给数组排序
* */



public class _15threeSum_correct {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ls = new ArrayList<>();

        for( int i = 0; i < nums.length; i++){
            if(i == 0 || nums[i] != nums[i - 1]){        //跳过可能重复的答案

                int l = i + 1, r = nums.length - 1, sum = 0 - nums[i];
                while(l < r){
                    if(nums[l] + nums[r] == sum){
                        ls.add(Arrays.asList(nums[i],nums[l],nums[r]));
                        while(l<r&&nums[l]==nums[l+1])  l++;
                        while(l<r&&nums[r]==nums[r-1])  r--;
                        l++;
                        r--;
                    }
                    else if(nums[l]+nums[r]<sum){
                        while(l<r &&nums[l] == nums[l+1]) l++;      //跳过重复值
                        l++;
                    }
                    else{
                        while (l<r &&nums[r]== nums[r-1]) r--;
                        r--;
                    }
                }
            }
        }
        return ls;
    }

    public static void main(String[] args) {

    }
}
