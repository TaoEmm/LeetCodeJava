package com.ktao.leetcode.搜索.组合;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @version 1.0
 * @author: kongtao
 * @description:
 * @date: 2020/4/25 4:14 下午
 */
public class CombinationSumII {
    /**
     * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     *
     * candidates 中的每个数字在每个组合中只能使用一次。
     *
     * 说明：
     *
     * 所有数字（包括目标数）都是正整数。
     * 解集不能包含重复的组合。 
     * 示例 1:
     *
     * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
     * 所求解集为:
     * [
     *   [1, 7],
     *   [1, 2, 5],
     *   [2, 6],
     *   [1, 1, 6]
     * ]
     * 示例 2:
     *
     * 输入: candidates = [2,5,2,1,2], target = 5,
     * 所求解集为:
     * [
     *   [1,2,2],
     *   [5]
     * ]
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[candidates.length];
        // 1.排序
        Arrays.sort(candidates);
        helper(res, 0, visited, new ArrayList<>(), candidates, target);
        return res;
    }

    private void helper(List<List<Integer>> res, int start, boolean[] visited, List<Integer> list, int[] candidates, int target){
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(list));
        }
        for (int i = start; i < candidates.length; i++){
            // 去重
            if (visited[i]) continue;
            if (i >= 1 && candidates[i] == candidates[i-1] && !visited[i-1]) continue;
            visited[i] = true;
            list.add(candidates[i]);
            helper(res, i+1, visited, list, candidates, target - candidates[i]);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
}
