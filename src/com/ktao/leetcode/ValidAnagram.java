package com.ktao.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author kongtao
 * @version 1.0
 * @description:
 * @date 2020/5/30
 **/
public class ValidAnagram {
    /**
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     *
     * 示例 1:
     *
     * 输入: s = "anagram", t = "nagaram"
     * 输出: true
     * 示例 2:
     *
     * 输入: s = "rat", t = "car"
     * 输出: false
     */

    public boolean isAnagram(String s, String t) {
        int[] s1 = new int[26];
        if (s.length() != t.length()) return false;
        for (int i = 0; i < s.length(); i++){
            s1[s.charAt(i) - 'a']++;
            s1[t.charAt(i) - 'a']--;
        }
        for (int c : s1) {
            if (c != 0) return false;
        }
        return true;
    }
}
