package org.educative.linkedlist.examples;

import org.educative.linkedlist.common.LinkedListUtil;

import static org.educative.linkedlist.common.LinkedListUtil.printList;

public class LinkedListUnionIntersection {

    public static LinkedListNode<Integer> union(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2) {

        // Replace this placeholder return statement with your code
        //Merge the two list
        LinkedListNode<Integer> mergedListHead = merge(head1, head2);
        printList(mergedListHead, "union");

        //Remove duplicate
        LinkedListNode<Integer> original = mergedListHead;
        LinkedListNode<Integer> duplicate = mergedListHead;

        while(original != null) {
            if (duplicate.next != null && original.data.equals(duplicate.next.data)) {
                duplicate.next = duplicate.next.next;
                continue;
            }

            duplicate = duplicate.next;

            if (duplicate == null) {
                original = original.next;
                duplicate = original;
            }

        }


        return mergedListHead;
    }

    // performs intersection between list
    public static LinkedListNode<Integer> intersection(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2) {

        // Replace this placeholder return statement with your code
        // Merge the two list
        LinkedListNode<Integer> mergedListHead = merge(head1, head2);
        printList(mergedListHead, "intersection");

        // Remove duplicate and push to another list and return
        LinkedListNode<Integer> original = mergedListHead;
        LinkedListNode<Integer> duplicate = mergedListHead;
        LinkedListNode<Integer> intersection = null;

        while(original != null) {
            if (duplicate.next != null && original.data.equals(duplicate.next.data)) {
                if (intersection == null) {
                    intersection = duplicate;
                } else {
                    intersection.next = duplicate;
                }
                duplicate.next = duplicate.next.next;
            }

            duplicate = duplicate.next;

            if (duplicate == null) {
                original = original.next;
                duplicate = original;
            }

        }

        return intersection;
    }

    private static LinkedListNode<Integer> merge(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2) {
        LinkedListNode<Integer> traverseFirst = head1;
        while(traverseFirst.next != null) {
            traverseFirst = traverseFirst.next;
        }
        traverseFirst.next = head2;

        return head1;
    }

    public static void main(String[] args) {
        printList(intersection(LinkedListUtil.getLinkedList(new int[] {15,22,14}), LinkedListUtil.getLinkedList(new int[] {15,14,21})), "LinkedListUnionIntersection");
    }
}
