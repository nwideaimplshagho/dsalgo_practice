package org.educative.queue.solution;

import lombok.extern.slf4j.Slf4j;
import org.educative.queue.common.MyStackImpl;

/**
 * Statement
 *
 * Design a queue data structure using only two stacks and implement the following functions:
 *
 * enqueue(int x): Inserts a value to the back of the queue.
 * dequeue(): Removes and returns the value from the front of the queue.
 * Constraints:
 *
 * −10^5 ≤ x ≤ 10^5
 */
@Slf4j
class QueueWithStack {
    int size;
    int maxSize;
    MyStackImpl<Integer> myStack;
    MyStackImpl<Integer> dequeueStack;

    public QueueWithStack(int maxSize) {
        // Write your code here
        myStack = new MyStackImpl<>(maxSize);
        dequeueStack = new MyStackImpl<>(maxSize);
        this.maxSize = maxSize;
        this.size = 0;
    }

    public void enqueue(int value) {
        if (size == maxSize) {
            throw new RuntimeException(String.format("Queue is full, can't enqueue, max size %d", myStack.getMaxSize()));
        }

        myStack.push(value);
        size++;
    }

    public int dequeue() {
        int value = -1;
        if (size <= 0) {
            throw new RuntimeException("Queue is empty, can't dequeue");
        }

        while (myStack.getCurrentSize() > 1) {
            dequeueStack.push(myStack.pop());
        }

        value = myStack.pop();

        while (!dequeueStack.isEmpty()) {
            myStack.push(dequeueStack.pop());
        }
        size++;
        return value;
    }

    public static void main(String[] args) {
        QueueWithStack queueWithStack = new QueueWithStack(5);
        queueWithStack.enqueue(1);
        queueWithStack.enqueue(2);
        queueWithStack.enqueue(4);
        queueWithStack.enqueue(6);
        queueWithStack.enqueue(7);
        log.info("Dequeued value {}", queueWithStack.dequeue());
        queueWithStack.enqueue(10);
        queueWithStack.printQueue();
    }

    private void printQueue() {
        int value = -1;
        while (!myStack.isEmpty()) {
            dequeueStack.push(myStack.pop());
        }
        while (!dequeueStack.isEmpty()) {
            value = dequeueStack.pop();
            myStack.push(value);
            log.info("Value is {}", value);
        }
    }
}