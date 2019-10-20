import java.util.*;

/*
* 本题和上题不同之处在于：
* 本题中每个数字只能在每个组合中使用一次
* */

public class _40cobunationSum2 {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        backtrace(candidates, target, res, 0, new Stack<>());
        return res;
    }

    private static void backtrace(int[] candidates, int target, List<List<Integer>> res, int i, Stack<Integer> stack){
        //递归结束
        if(target < 0)
            return;
        if(target == 0){
            res.add(new ArrayList<>(stack));
            return;
        }


        //中间节点
        for(int start = i; start < candidates.length && candidates[start] <= target; start++){
            //本题重点：
            //保证每个数字只被用一次，同时跳过相同的数字
            if(start  != i && candidates[start] == candidates[start - 1])
                continue;
            //入栈
            stack.add(candidates[start]);
            backtrace(candidates,target - candidates[start], res, start + 1, stack);
            //出栈
            stack.pop();
        }
    }



    public static void main(String[] args) {
        int [] candidates1 = new int[]{10,1,2,2,7,6,1,5};
        System.out.println(combinationSum2(candidates1,8));

        int [] candidates2 = new int[]{2,5,2,1,2};
        System.out.println(combinationSum2(candidates2,5));
    }
}
