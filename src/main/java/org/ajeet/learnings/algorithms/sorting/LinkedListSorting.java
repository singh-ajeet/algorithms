package org.ajeet.learnings.algorithms.sorting;

import org.ajeet.learnings.algorithms.list.ListNode;

public final class LinkedListSorting {

    public static ListNode<Integer> sort(ListNode<Integer> head) {
        //If empty list or has single element
        if(head == null || head.next == null){
            return head;
        }

        ListNode first = head;
        ListNode second  = extractLastHalf(head);

        first = sort(first);
        second = sort(second);

        return merge(first, second);
    }

    private static ListNode<Integer> merge(ListNode<Integer> first, ListNode<Integer> second) {
        ListNode<Integer> aux = new ListNode<>(-1);
        ListNode<Integer> tmp = aux;

        while(first != null && second != null){
            if(first.value < second.value) {
                tmp.next = first;
                first = first.next;
            } else {
                tmp.next = second;
                second = second.next;
            }
            tmp = tmp.next;
            tmp.next = null;
        }

        tmp.next = (first == null) ? second : first;
        return aux.next;
    }

    private static ListNode<Integer> extractLastHalf(ListNode<Integer> head) {
        ListNode slow = head;
        ListNode pre = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        pre.next = null;
        return slow;
    }

    public static void main(String[] args) {
        ListNode<Integer> node8 = new ListNode<>(8);
        ListNode<Integer> node3 = new ListNode<>(3, node8);
        ListNode<Integer> node2 = new ListNode<>(2, node3);
        ListNode<Integer> node4 = new ListNode<>(4, node2);
        ListNode<Integer> node5 = new ListNode<>(5, node4);

        ListNode<Integer> sorted = sort(node5);

        while (sorted != null) {
            System.out.print(sorted.value + "->");
            sorted = sorted.next;
        }

    }
}
