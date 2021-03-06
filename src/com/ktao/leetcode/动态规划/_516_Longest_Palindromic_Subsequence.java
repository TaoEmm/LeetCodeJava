package com.ktao.leetcode.动态规划;

/**
 * @author kongtao
 * @version 1.0
 * @description:
 * @date 2020/6/7
 **/
public class _516_Longest_Palindromic_Subsequence {

    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) return 0;
        int len = s.length();
        int[][] dp = new int[len][len];
        for (int i = len - 1 ; i >= 0; i--){
            dp[i][i] = 1;
            for (int j = i + 1; j < len; j++){
                if (s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][len - 1];
    }
}
