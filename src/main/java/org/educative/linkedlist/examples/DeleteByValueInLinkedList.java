package org.educative.linkedlist.examples;

public class DeleteByValueInLinkedList {
    public boolean deleteByValue(LinkedListNode <Integer> head, int value) {
        //Replace this placeholder return statement with your code
        if (head == null) {
            return false;
        }
        LinkedListNode<Integer> toBeDeleted = head;
        LinkedListNode<Integer> prevOfToBeDeleted = toBeDeleted;

        while (toBeDeleted != null) {
            if (toBeDeleted.data == value) {
                //If it is head node
                if (head.data == toBeDeleted.data) {
                    head.next = toBeDeleted.next;
                } else  {
                    //If it is middle node or //If it is tail node
                    prevOfToBeDeleted.next = toBeDeleted.next;
                }
                return true;
            }
            prevOfToBeDeleted = toBeDeleted;
            toBeDeleted = toBeDeleted.next;
        }

        return false;
    }
}
