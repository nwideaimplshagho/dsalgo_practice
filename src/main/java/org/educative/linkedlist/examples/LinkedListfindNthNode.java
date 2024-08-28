package org.educative.linkedlist.examples;

/**
 * Statement
 * Given the head of a linked list, return the nth node from the end of the linked list.
 *
 * Constraints:
 *
 * The number of nodes in the list is k.
 *
 * 1≤ k ≤ 10^3
 *
 * 10^3 ≤ Node.data ≤ 10^3
 *
 * 1≤ n ≤ k
 */
public class LinkedListfindNthNode {

    public static LinkedListNode<Integer> findNth(LinkedListNode<Integer> head, int n) {

        //Take two pointers
        //Pointer to reach nth node from start
        //Actual nth node pointer
        //Loop on nthNodeStart pointer not null
        //Once nthNodeStart pointer reaches to nth node from start then start moving nthNode pointer
        //Once nthNodeStart == null then nthNodePointer will be to actual point
        LinkedListNode<Integer> nthNodeFromStart = head;
        LinkedListNode<Integer> nthNodeFromEnd = head;
        int counter = 1;
        while(counter <= n) {
            nthNodeFromStart = nthNodeFromStart.next;
            counter++;
        }
        while (nthNodeFromStart != null) {
            nthNodeFromEnd = nthNodeFromEnd.next;
            nthNodeFromStart = nthNodeFromStart.next;
        }

        return nthNodeFromEnd;
    }
}
