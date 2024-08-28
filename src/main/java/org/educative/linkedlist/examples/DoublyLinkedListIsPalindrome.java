package org.educative.linkedlist.examples;

import org.educative.linkedlist.common.DoublyLinkedListNode;

/**
 * Statement
 * Given the head of a doubly linked list, check whether the doubly linked list is a palindrome or not. Return TRUE if it is a palindrome; otherwise, return FALSE.
 * A palindrome is any string or sequence that reads the same from both ends. For example, 2002 is a palindrome.
 *
 * Constraints:
 * Let n be the number of nodes in a doubly linked list.
 *
 * 1≤ n ≤ 500
 *
 * 1≤ node.data ≤ 100
 */
public class DoublyLinkedListIsPalindrome {
    public static boolean isPalindrome(DoublyLinkedListNode head) {

        // Replace this placeholder return statement with your code
        //Find tail of doubly linkedlist
        DoublyLinkedListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        //Use two pointers left will start from head and right will start from tail
        DoublyLinkedListNode left = head;
        DoublyLinkedListNode right = tail;
        //run a loop, loop break condition = either left == right or left.next == right.prev


        while (left != right && left.next != right) {
            if (left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.prev;
        }

        //For even sized linked list
        if (left.next == right) {
            if (left.data != right.data) {
                return false;
            }
        }


        return true;
    }
}
