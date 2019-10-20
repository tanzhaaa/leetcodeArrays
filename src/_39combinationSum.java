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
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        //排序
        Arrays.sort(candidates);
        backtrack(candidates, target, res, 0, new ArrayList<>());
        return res;
    }
    private static void backtrack(int[] candidates, int target, List<List<Integer>> res, int i, ArrayList<Integer> tmp_list) {
        //递归结束条件
        //当总和超过target
        if (target < 0) return;
        //和为target将这组答案加入返回的数组
        if (target == 0) {
            res.add(new ArrayList<>(tmp_list));
            return;
        }

        //中间节点，继续向下递归
        for (int start = i; start < candidates.length; start++) {
            //当前节点入栈
            tmp_list.add(candidates[start]);
            backtrack(candidates, target - candidates[start], res, start, tmp_list);
            //当前节点退栈
            tmp_list.remove(tmp_list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int [] candidates = new int[]{2,3,6,7};
        System.out.println(combinationSum(candidates,7));
    }
}
