package org.educative.queue.solution;

import org.educative.queue.common.CheckSortStack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CheckSort {
    private static final Logger log = LoggerFactory.getLogger(CheckSort.class);

    public static CheckSortStack<Integer> sortStack(CheckSortStack<Integer> input) {

        CheckSortStack<Integer> result = new CheckSortStack< Integer > (input.getMaxSize());

        while (!input.isEmpty()) {
            //If result empty then pop from input stack
            if (result.isEmpty()) {
                result.push(input.pop());
            }

            // //Only for 1 size stack
            if (input.isEmpty()) {
                break;
            }

            // initialise a popCounter
            int popCounter = 0;
            //loop through result if input top > result top && result.isNotEmpty
            int tempTop = input.pop();
            //pop from result stack, push to input & increment popCounter
            while ( !result.isEmpty() && result.top() < tempTop) {
                input.push(result.pop());
                popCounter++;
            }
            //Push tempTop into result
            result.push(tempTop);

            //loop on input till popCounter > 0
            while (popCounter > 0) {
                result.push(input.pop());
                popCounter--;
            }
        }
        return result;
    }

    public static void printStack (CheckSortStack<Integer> result) {
        int value = -1;
        CheckSortStack<Integer> tempStack = new CheckSortStack<>(result.getMaxSize());

        while (!result.isEmpty()) {
            value = result.pop();
            tempStack.push(value);
            log.info("Value {}", value);
        }

        while (!tempStack.isEmpty()) {
            result.push(tempStack.pop());
        }
    }

    public static void main(String[] args) {
        CheckSortStack<Integer> input = new CheckSortStack<>(5);
        input.push(-40);
        input.push(-2);
        input.push(-1);
        input.push(-9);
        input.push(-5);
        CheckSortStack<Integer> result = CheckSort.sortStack(input);
        CheckSort.printStack(result);
    }
}
