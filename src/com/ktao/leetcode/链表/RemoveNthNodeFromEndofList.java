package com.ktao.leetcode.链表;

/**
 * 19.删除链表的倒数第N个节点
 * @version 1.0
 * @author: kongtao
 * @description:
 * @date: 2020/4/29 8:06 下午
 */
public class RemoveNthNodeFromEndofList {
    /**
     * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
     *
     * 示例：
     *
     * 给定一个链表: 1->2->3->4->5, 和 n = 2.
     *
     * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
     * 说明：
     *
     * 给定的 n 保证是有效的。
     *
     * 进阶：
     *
     * 你能尝试使用一趟扫描实现吗？
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;
        for (int i = 1; i <= n; i++){
            fast = fast.next;
        }
        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
