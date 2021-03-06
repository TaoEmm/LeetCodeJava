package com.ktao.leetcode.字符串;

import java.util.ArrayList;
import java.util.List;

/**
 * 68. 文本左右对齐
 * @author kongtao
 * @version 1.0
 * @description:
 * @date 2020/5/25
 **/
public class TextJustification {
    /**
     * 给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
     *
     * 你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
     *
     * 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
     *
     * 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
     *
     * 说明:
     *
     * 单词是指由非空格字符组成的字符序列。
     * 每个单词的长度大于 0，小于等于 maxWidth。
     * 输入单词数组 words 至少包含一个单词。
     * 示例:
     *
     * 输入:
     * words = ["This", "is", "an", "example", "of", "text", "justification."]
     * maxWidth = 16
     * 输出:
     * [
     *    "This    is    an",
     *    "example  of text",
     *    "justification.  "
     * ]
     */
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int n = words.length;
        int index = 0;
        while (index < n){
            int totalChars = words[index].length();
            int last = index + 1;
            while (last < n){
                if (totalChars + words[last].length() + 1 > maxWidth) break;
                totalChars += (1 + words[last].length());
                last++;
            }
            int gaps = last - index - 1;
            StringBuilder sb = new StringBuilder();

            if (last == n || gaps == 0){
                for (int i = index; i < last; i++){
                    sb.append(words[i]).append(' ');
                }
                sb.deleteCharAt(sb.length() - 1);
                while (sb.length() < maxWidth){
                    sb.append(' ');
                }
            } else {
                int spaces = (maxWidth - totalChars) / gaps;
                int rest = (maxWidth - totalChars) % gaps;

                for (int i = index; i < last - 1; i++){
                    sb.append(words[i]).append(' ');
                    for (int j = 0; j < spaces + (i - index < rest ? 1 : 0); j++){
                        sb.append(' ');
                    }
                }
                sb.append(words[last - 1]);
            }
            res.add(sb.toString());
            index = last;
        }
        return res;
    }
}
