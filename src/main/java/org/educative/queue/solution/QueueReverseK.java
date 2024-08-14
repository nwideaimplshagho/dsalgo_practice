package org.educative.queue.solution;

import lombok.extern.slf4j.Slf4j;
import org.educative.queue.common.MyQueue;

@Slf4j
public class QueueReverseK {
    public static MyQueue<Integer> reverseK(MyQueue<Integer> queue, int k) {
        log.info("Front {} , rear {}", queue.front(), queue.rear());
        while (!queue.isEmpty()) {
            log.info("Element is {}", queue.dequeue());
        }
        // Replace this placeholder return statement with your code
        return queue;
    }

    public static void main(String[] args) {
        MyQueue<Integer> myQueue1 = new MyQueue<>();
        myQueue1.enqueue(1);
        myQueue1.enqueue(5);
        myQueue1.enqueue(6);
        myQueue1.enqueue(4);
        reverseK(myQueue1, 3);
    }
}
