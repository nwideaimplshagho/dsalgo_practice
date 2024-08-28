package org.educative.queue.solution;

import lombok.extern.slf4j.Slf4j;
import org.educative.queue.common.MinStackMyStack;


/**
 * Statement
 * Design a stack data structure to retrieve the minimum value in O(1) time. The following functions must be implemented:
 *
 * min(): Returns the minimum value in the stack in constant time.
 * push(int value): Pushes a value onto the stack.
 * pop(): Removes and returns a value from the top of the stack.
 * All functions should be implemented with a time complexity of O(1) .
 *
 *
 * Constraints:
 *
 * −10^5 ≤ value ≤10^5
 */

@Slf4j
class MinStack {
    int maxSize;
    MinStackMyStack<Integer> originalValStack;
    MinStackMyStack<Integer> minValStack;

    //constructor
    public MinStack(int maxSize) {
        this.maxSize = maxSize;
        this.originalValStack = new MinStackMyStack<>(maxSize);
        this.minValStack = new MinStackMyStack<>(maxSize);
    }

    //removes and returns value from stack
    public Integer pop() {
        if (originalValStack.isEmpty()) {
            return null;
        }
        minValStack.pop();

        return originalValStack.pop();
    }
    //pushes value into the stack
    public void push(Integer value) {
        originalValStack.push(value);
        if (minValStack.isEmpty()) {
            minValStack.push(value);
            return;
        }
        if (minValStack.top() < value) {
            minValStack.push(minValStack.top());
        } else {
            minValStack.push(value);
        }
    }

    //returns minimum value in O(1)
    public int min() {
        return minValStack.top();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack(2);
        minStack.push(4);
        minStack.push(8);
        log.info("Minimum {}", minStack.min());

    }
}
