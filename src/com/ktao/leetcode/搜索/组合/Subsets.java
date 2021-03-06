package com.ktao.leetcode.搜索.组合;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 78. 子集
 * @version 1.0
 * @author: kongtao
 * @description:
 * @date: 2020/4/25 5:54 下午
 */
public class Subsets {
    /**
     * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
     *
     * 说明：解集不能包含重复的子集。
     *
     * 示例:
     *
     * 输入: nums = [1,2,3]
     * 输出:
     * [
     *   [3],
     *   [1],
     *   [2],
     *   [1,2,3],
     *   [1,3],
     *   [2,3],
     *   [1,2],
     *   []
     * ]
     */
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        helper(res, new ArrayList<>(), nums, 0);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> list, int[] nums, int start){
        for (int i = start; i < nums.length; i++){
            list.add(nums[i]);
            res.add(new ArrayList<>(list));
            helper(res, list, nums, i+1);
            list.remove(list.size()-1);
        }
    }
}
