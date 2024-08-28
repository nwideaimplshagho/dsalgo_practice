package org.educative.queue.solution;

import lombok.extern.slf4j.Slf4j;
import org.educative.queue.common.MyQueue;
import org.educative.queue.common.MyStack;


/**
 * Given a queue and a number k, reverse the order of the first k elements in queue. If k is less than
 * 0 , if k exceeds queue size, or if queue is empty, return NULL. Otherwise, return the modified queue.
 *
 * Constraints:
 * 0≤ queue.length ≤ 10^3
 *
 * 10^−3 ≤ queue[i] ≤ 10^3
 *
 * 10^−3 ≤ ≤  k ≤ 10^3
 */
@Slf4j
public class QueueReverseK {

    public static MyQueue<Integer> reverseKUsingStack(MyQueue<Integer> queue, int k) {
        int queueSize = queue.size();
        int[] tempArray = new int[queueSize];

        //Push all elements in to an array
        for (int idx = 0 ; !queue.isEmpty(); idx++) {
            tempArray[idx] = queue.dequeue();
        }

        //Loop through k - 1 index to 0 of the array and push them into input queue
        for (int idx = k - 1 ; idx >= 0; idx--) {
            queue.enqueue(tempArray[idx]);
        }

        //Loop through k to array.length - 1 of the and push them into input queue
        for (int idx = k ; idx < tempArray.length; idx++) {
            queue.enqueue(tempArray[idx]);
        }

        return queue;
    }

    public static MyQueue<Integer> reverseKUsingArray(MyQueue<Integer> queue, int k) {
        int queueSize = queue.size();

        //Push all elements into a an
        MyStack<Integer> tempStack = new MyStack<>();
        int counter = 0;
        while (counter < k) {
            tempStack.push(queue.dequeue());
            counter++;
        }
        //Push n (size of queue) into a queue of size (n-k)
        MyQueue<Integer> tempQueue = new MyQueue<>();
        counter = k;

        while ( counter < queueSize) {
            tempQueue.enqueue(queue.dequeue());
            counter++;
        }


        //Pop k elements from temp stack , push into old queue
        while (!tempStack.isEmpty()) {
            queue.enqueue(tempStack.pop());
        }

        //Pop elements from temp queue into main queue
        while (!tempQueue.isEmpty()) {
            queue.enqueue(tempQueue.dequeue());
        }

        return queue;
    }

    public static void main(String[] args) {
        MyQueue<Integer> myQueue1 = new MyQueue<>();
        myQueue1.enqueue(1);
        myQueue1.enqueue(2);
        myQueue1.enqueue(3);
        myQueue1.enqueue(-4);
        myQueue1.enqueue(5);
        myQueue1.enqueue(6);
        myQueue1.enqueue(7);
        myQueue1.enqueue(8);
        myQueue1.enqueue(9);
        myQueue1.enqueue(10);

//        MyQueue<Integer> resultQueue = reverseKUsingStack(myQueue1, 5);
        MyQueue<Integer> resultQueue = reverseKUsingArray(myQueue1, 5);
        while (!resultQueue.isEmpty()) {
            log.info("main :: Value is {}", resultQueue.dequeue());
        }

    }
}
