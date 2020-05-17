package com.ktao.leetcode.搜索;

import java.util.*;

/**
 * 126.单词接龙 II
 * @author kongtao
 * @version 1.0
 * @description:
 * @date 2020/5/16
 **/
public class WordLadderII {
    /**
     * 给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。转换需遵循如下规则：
     *
     * 每次转换只能改变一个字母。
     * 转换过程中的中间单词必须是字典中的单词。
     * 说明:
     *
     * 如果不存在这样的转换序列，返回一个空列表。
     * 所有单词具有相同的长度。
     * 所有单词只由小写字母组成。
     * 字典中不存在重复的单词。
     * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
     * 示例 1:
     *
     * 输入:
     * beginWord = "hit",
     * endWord = "cog",
     * wordList = ["hot","dot","dog","lot","log","cog"]
     *
     * 输出:
     * [
     *   ["hit","hot","dot","dog","cog"],
     *   ["hit","hot","lot","log","cog"]
     * ]
     * 示例 2:
     *
     * 输入:
     * beginWord = "hit"
     * endWord = "cog"
     * wordList = ["hot","dot","dog","lot","log"]
     *
     * 输出: []
     *
     * 解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。
     */
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>();
        for (String word : wordList) dict.add(word);
        List<List<String>> res = new ArrayList<>();
        Queue<List<String>> queue = new LinkedList<>();
        List<String> path = new ArrayList<>();
        path.add(beginWord);
        queue.offer(path);
        while (!queue.isEmpty()){
            int size = queue.size();
            if (!res.isEmpty()) return res;
            for (int i = 0; i < size; i++){
                List<String> curList = queue.poll();
                String curWord = curList.get(curList.size() - 1);
                if (curWord.equals(endWord)){
                    res.add(new ArrayList<>(curList));
                } else {
                    StringBuilder sb = new StringBuilder(curWord);
                    for (int j = 0; j < curWord.length(); j++){
                        for (char c = 'a'; c <= 'z'; c++){
                            if (c == curWord.charAt(j)) continue;
                            sb.setCharAt(j, c);
                            if (dict.contains(sb.toString())){
                                curList.add(sb.toString());
                                queue.offer(new ArrayList<>(curList));
                                curList.remove(curList.size() - 1);
                                dict.remove(curWord);
                            }
                        }
                        sb.setCharAt(j, curWord.charAt(j));
                    }
                }
            }
        }
        return res;
    }
}
