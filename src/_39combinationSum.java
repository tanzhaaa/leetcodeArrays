import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/*
* 本题参考别人的答案：
* 回溯算法
*
*
* 这类题目都是同一类型的,用回溯算法!
其实回溯算法关键在于:不合适就退回上一步
然后通过约束条件, 减少时间复杂度.
类似题目还有:
[39.组合总和](https://leetcode-cn.com/problems/combination-sum/)

[40. 组合总和 II](https://leetcode-cn.com/problems/combination-sum-ii/)

[46. 全排列](https://leetcode-cn.com/problems/permutations/)

[47. 全排列 II](https://leetcode-cn.com/problems/permutations-ii/)

[78. 子集](https://leetcode-cn.com/problems/subsets/)

[90. 子集 II](https://leetcode-cn.com/problems/subsets-ii/)


*
* */
public class _39combinationSum {
    static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        //System.out.println(candidates);
        backtrack(candidates, target, res, 0, new ArrayList<Integer>());
        return res;
        }


    private static void backtrack(int[] candidates, int target, List<List<Integer>> res, int i, ArrayList<Integer> tmp_list) {
        for (int start = i; start < candidates.length; start++) {
            //System.out.println(start);
            tmp_list.add(candidates[start]);
            //System.out.println(tmp_list);
            backtrack(candidates, target - candidates[start], res, start, tmp_list);
            tmp_list.remove(tmp_list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int [] candidates = new int[]{2,3,6,7};
        System.out.println(combinationSum(candidates,7));
    }
}
