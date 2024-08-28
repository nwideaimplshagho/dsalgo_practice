package org.educative.queue.solution;

import lombok.extern.slf4j.Slf4j;
import org.educative.queue.common.NextGreaterElementStack;

import java.util.Arrays;

/**
 * Statement#
 * Implement a nextGreaterElement() function that takes an array of integers, arr, as input and returns the next greater number for every element in the array.
 *
 * The next greater number for a number arr[i] is the first number to its right that is greater than arr[i]. If no such number exists, return -1 for this number.
 *
 * Constraints:
 *
 * 1 ≤ arr.length ≤ 10^3
 *
 * 0 ≤ arr[i] ≤ 10^3
 */
@Slf4j
public class NextGreaterElementUsingStack {
    public static int[] nextGreaterElement(int[] arr) {
        int[] result = new int[arr.length];

        Arrays.fill(result, -1);

        //Store values from input array
        NextGreaterElementStack<Integer> valueStack = new NextGreaterElementStack<>();

        //Loop through the input array from last
        int inputSize = arr.length;

        //Compare top of stack with current index value
        for (int idx = inputSize - 1; idx >= 0; idx--) {
            // If valueStack empty then push current value in stack
            //if empty then no change in result
            if (valueStack.isEmpty()) {
                valueStack.push(arr[idx]);
                continue;
            }
            int inpValue = arr[idx];

            //Loop through the valueStack
            while (!valueStack.isEmpty()) {
                //if stack not empty
                int valueStackTop = valueStack.peek();

                if (valueStackTop > inpValue) {
                    // if top of stack > value then result[current index] = top of stack
                    result[idx] = valueStackTop;
                    break;
                }

                // else pop top of stack
                valueStack.pop();
            }

            //push current value in stack
            valueStack.push(inpValue);
        }

        return result;
    }
}
