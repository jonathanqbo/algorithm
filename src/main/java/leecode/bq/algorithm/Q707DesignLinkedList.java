package leecode.bq.algorithm;

import leecode.bq.ListNode;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 12/29/20 10:38 AM
 */
public class Q707DesignLinkedList {
}

/**
 * solution 1: singly linked list
 *
 * Runtime: 9 ms, faster than 67.44% of Java online submissions for Design Linked List.
 * Memory Usage: 39.7 MB, less than 54.54% of Java online submissions for Design Linked List.
 *
 */
class MyLinkedList {

    int size = 0;
    ListNode head = new ListNode(-1);
    ListNode tail = head;

    /** Initialize your data structure here. */
    public MyLinkedList() {

    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index >= size) {
            return -1;
        }

        ListNode node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }

        return node.next.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        ListNode node = new ListNode(val);
        node.next = head.next;
        head.next = node;

        size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }

        ListNode node = new ListNode(val);

        ListNode pre = head;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        node.next = pre.next;
        pre.next = node;
        size++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index >= size) {
            return;
        }

        ListNode pre = head;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }

        pre.next = pre.next.next;
        size--;
    }
}

/**
 * solution 2: Doubly linked list
 *
 * Runtime: 7 ms, faster than 95.14% of Java online submissions for Design Linked List.
 * Memory Usage: 39.5 MB, less than 82.10% of Java online submissions for Design Linked List.
 *
 */
class MyLinkedList2 {

    int size = 0;
    ListNode head = new ListNode(-1);
    ListNode tail = head;

    /** Initialize your data structure here. */
    public MyLinkedList2() {
        size = 0;
        head = new ListNode(-1);
        tail = new ListNode(-1);
        head.next = tail;
        tail.pre = head;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index >= size) {
            return -1;
        }

        ListNode node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }

        return node.next.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        ListNode node = new ListNode(val);

        node.next = head.next;
        head.next.pre = node;
        node.pre = head;
        head.next = node;

        size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        ListNode node = new ListNode(val);

        tail.pre.next = node;
        node.pre = tail.pre;
        node.next = tail;
        tail.pre = node;

        size++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }

        ListNode node = new ListNode(val);

        ListNode pre = head;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }

        node.next = pre.next;
        pre.next.pre = node;
        node.pre = pre;
        pre.next = node;

        size++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index >= size) {
            return;
        }

        ListNode pre = head;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }

        pre.next.next.pre = pre;
        pre.next = pre.next.next;

        size--;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode pre;
        ListNode(int x) { val = x; }
    }
}

