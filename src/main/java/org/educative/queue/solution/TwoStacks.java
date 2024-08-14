package org.educative.queue.solution;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Design a data structure TwoStacks, that represents two stacks using a single array, where both
 * stacks share the same array for storing elements.
 * The following operations must be supported:
 *
 * push1(value): Takes an integer value and inserts it into the first stack.
 *
 * push2(value): Takes an integer value and inserts it into the second stack.
 *
 * pop1(): Removes the top element from the first stack and returns it.
 *
 * pop2(): Removes the top element from the second stack and returns it.
 *
 * Note: Perform all operations in-place without resizing the underlying list, maintaining a fixed size throughout.
 *
 * Constraints:
 *
 * 1
 * ≤
 * 1≤
 *  arr.length
 * ≤
 * 1
 * 0
 * 3
 * ≤10
 * 3
 *
 *
 * −
 * 1
 * 0
 * 5
 * ≤
 * −10
 * 5
 *  ≤
 *  value, value2
 * ≤
 * 1
 * 0
 * 5
 * ≤10
 * 5
 * @param <V>
 */
class TwoStacks < V > {
    private static final Logger log = LoggerFactory.getLogger(TwoStacks.class);
    private int arraySize;
    private V[] array;
    private int top1;
    private int top2;

    @SuppressWarnings("unchecked")
    public TwoStacks(int arraySize) {
        this.arraySize = arraySize;
        array = (V[]) new Object[arraySize]; //type casting Object[] to V[]
        top1 = -1;
        top2 = arraySize;
    }

    private boolean isEmpty1() {
        return top1 < 0;
    }

    private boolean isEmpty2() {
        return top2 == arraySize;
    }

    private boolean isFull1() {
        return top1 == (arraySize - 1) || (top1 + 1 ) == top2;
    }

    private boolean isFull2() {
        return top2 == 0 || (top2 - 1 ) == top1;
    }

    //insert at top of first stack
    public void push1(V value) {
        if (isFull1()) {
            return;
        }

        top1+=1;
        array[top1] = value;
    }

    //insert at top of second stack
    public void push2(V value) {
        if (isFull2()) {
            return;
        }

        top2-=1;
        array[top2] = value;
    }

    //remove and return value from top of first stack
    public V pop1() {
        if (isEmpty1()) {
            return null;
        }
        V retVal = array[top1];
        top1-=1;
        return retVal;
    }

    //remove and return value from top of second stack
    public V pop2() {
        if (isEmpty2()) {
            return null;
        }
        V retVal = array[top2];
        top2+=1;
        return retVal;
    }

    public static void main(String[] args) {
        TwoStacks<Integer> twoStacks = new TwoStacks<>(5);
        twoStacks.push1(-3);
        twoStacks.push2(5);
        Integer val1 = twoStacks.pop1();
        Integer val2 = twoStacks.pop2();
        twoStacks.push1(10);

        log.info("Popped values {}, {}", val1, val2);
    }
}
